package site.easy.to.build.crm.service.ticket;


import java.util.Optional;

import site.easy.to.build.crm.entity.TicketExpense;

public interface TicketExpenseService {
    TicketExpense save(TicketExpense ticketExpense);

    Optional<TicketExpense> getLatestExpenseForTicketHisto(int ticketHistoId);
}
