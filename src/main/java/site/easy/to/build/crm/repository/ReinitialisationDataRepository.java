package site.easy.to.build.crm.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ReinitialisationDataRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String resetDatabase() {
        try {
            entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE employee;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE email_template;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE customer_login_info;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE customer;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE trigger_lead;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE trigger_ticket;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE trigger_contract;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE contract_settings;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE lead_action;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE lead_settings;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE ticket_settings;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE file;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE google_drive_file;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE trigger_lead_histo;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE lead_expense;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE trigger_ticket_histo;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE TABLE ticket_expense;").executeUpdate();
            entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1;").executeUpdate();
        } catch (Exception e) {
            return "Failed to Reset :" + e.getMessage();
        }
        return "Data reseted with Success";
    }
}
