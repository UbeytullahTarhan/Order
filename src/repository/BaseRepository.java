package repository;

import model.ModelBase;

import java.util.List;

public interface BaseRepository<T extends ModelBase> {

    List<T> getAll();

    T getById(Long id);

    T add(T entity);
}
