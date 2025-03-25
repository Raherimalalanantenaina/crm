package site.easy.to.build.crm.service.ticket;

import org.springframework.stereotype.Service;

import site.easy.to.build.crm.entity.LeadExpense;
import site.easy.to.build.crm.entity.TicketExpense;
import site.easy.to.build.crm.repository.TicketExpenseRepository;

import java.util.Optional;

@Service
public class TicketExpenseServiceImpl implements TicketExpenseService{
    private final TicketExpenseRepository ticketExpenseRepository;


    public TicketExpenseServiceImpl(TicketExpenseRepository ticketExpenseRepository) {
        this.ticketExpenseRepository = ticketExpenseRepository;
    }

    @Override
    public TicketExpense save(TicketExpense ticketExpense){
        return ticketExpenseRepository.save(ticketExpense);
    }

    @Override
    public Optional<TicketExpense> getLatestExpenseForTicketHisto(int ticketHistoId) {
        Optional<TicketExpense> latestExpense = ticketExpenseRepository.findByIdHistoDateMax(ticketHistoId);
        return latestExpense;
    }

    @Override
    public TicketExpense findById(int id) {
        Optional<TicketExpense> result = ticketExpenseRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Dépense non trouvée avec l'ID: " + id);
        }

        return result.get();
    }
}
