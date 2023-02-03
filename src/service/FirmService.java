package service;

import model.Firm;
import repository.FirmRepository;

import java.util.List;

public class FirmService implements  BaseService<Firm> {

    private final FirmRepository firmRepository;

    public FirmService(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }


    @Override
    public List<Firm> getAll() {
        return firmRepository.getAll();
    }

    @Override
    public Firm getById(Long id) {
        return firmRepository.getById(id);
    }


    public Firm add(Firm entity) {
        return firmRepository.add(entity);
    }
}
