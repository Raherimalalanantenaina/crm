package site.easy.to.build.crm.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import site.easy.to.build.crm.entity.LeadExpense;
import site.easy.to.build.crm.entity.TicketExpense;
import site.easy.to.build.crm.service.ticket.TicketExpenseService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket-expenses")
public class TicketExpenseRestController {

    @Autowired
    private TicketExpenseService ticketExpenseService;

    // Récupérer une dépense par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TicketExpense>> getById(@PathVariable int id) {
        // Récupération de la dépense à partir du service
        Optional<TicketExpense> ticketExpense = ticketExpenseService.getLatestExpenseForTicketHisto(id);
        return ResponseEntity.ok(ticketExpense);
    }


    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketExpense> getExpenseByIdLead(@PathVariable("id") int id) {
        Optional<TicketExpense> expense = Optional.ofNullable(ticketExpenseService.findById(id));
        return expense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Mettre à jour une dépense
    @PutMapping("/modif")
    public ResponseEntity<TicketExpense> update(@Valid @RequestBody TicketExpense updatedTicketExpense) {
        TicketExpense existingTicketExpense = new TicketExpense();
        existingTicketExpense.setAmount(updatedTicketExpense.getAmount());
        existingTicketExpense.setCreatedAt(LocalDateTime.now());
        existingTicketExpense.setTicketHisto(updatedTicketExpense.getTicketHisto());
        TicketExpense savedTicketExpense = ticketExpenseService.save(existingTicketExpense);
        return ResponseEntity.ok(savedTicketExpense); // 200 OK
    }

        @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalExpenses(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        BigDecimal total = ticketExpenseService.getTotalExpensesBetweenDates(startDate, endDate);
        return ResponseEntity.ok(total);
    }
}