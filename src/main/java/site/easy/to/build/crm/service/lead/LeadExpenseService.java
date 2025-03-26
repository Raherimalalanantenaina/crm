package site.easy.to.build.crm.service.lead;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import site.easy.to.build.crm.entity.LeadExpense;
public interface LeadExpenseService {
    public LeadExpense save(LeadExpense leadExpense);
    
    LeadExpense findById(int id);

    public LeadExpense findLatestByTriggerLeadHistoId(Integer triggerLeadHistoId);
    
    public BigDecimal getTotalExpensesBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
