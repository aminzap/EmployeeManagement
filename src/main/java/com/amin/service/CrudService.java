package com.amin.service;

import com.amin.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public abstract class CrudService<T, ID> {
    private final CrudRepository<T, ID> repository;

    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    public T findById(ID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
