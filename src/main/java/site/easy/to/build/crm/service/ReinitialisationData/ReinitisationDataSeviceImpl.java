package site.easy.to.build.crm.service.ReinitialisationData;

import org.springframework.stereotype.Service;

import site.easy.to.build.crm.repository.ReinitialisationDataRepository;

@Service
public class ReinitisationDataSeviceImpl implements ReinitialisationDataService{
    private final ReinitialisationDataRepository reinitialisationDataRepository;

    public ReinitisationDataSeviceImpl(ReinitialisationDataRepository reinitialisationDataRepository) {
        this.reinitialisationDataRepository = reinitialisationDataRepository;
    }

    @Override
    public String resetData() {
        return this.reinitialisationDataRepository.resetDatabase();
    }
}
