package repository;

import model.Sector;

import java.util.List;
import java.util.HashSet;

import java.util.Set;

public class SectorRepository implements BaseRepository<Sector> {
    private static final Set<Sector> sectors = new HashSet<>();


    @Override
    public List<Sector> getAll() {
        return sectors.stream().toList();
    }

    @Override
    public Sector getById(Long id) {
        return sectors.stream()
                .filter(sector -> sector.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Sector add(Sector entity) {
        return sectors.add(entity) ? entity : null;
    }
}
