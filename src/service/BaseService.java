package service;

import model.ModelBase;

import java.util.List;

public interface BaseService<T extends ModelBase> {
    List<T> getAll();

    T getById(Long id);

    T add(T entity);
}
