package service;


import model.Sector;
import repository.SectorRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SectorService implements  BaseService<Sector> {
    private final SectorRepository sectorRepository;
    final int LESS = -1;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }


    @Override
    public List<Sector> getAll() {
        return sectorRepository.getAll();
    }

    @Override
    public Sector getById(Long id) {
        return sectorRepository.getById(id);
    }

    @Override
    public Sector add(Sector entity) {
        return sectorRepository.add(entity);
    }


    public Set<Sector> getSectorOfCompaniesHaveInvoicesUnderAverageAmount(BigDecimal amount) {
        return sectorRepository.getAll()
                .stream()
                .flatMap(s ->
                        s.getCompanies()
                                .stream()
                                .filter(c ->
                                        c.getAverageInvoice().compareTo(amount) == LESS
                                )
                                .map(c -> c.getSector())
                )
                .collect(Collectors.toSet());
    }
}
