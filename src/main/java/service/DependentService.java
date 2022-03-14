package service;

import come.amin.entity.Department;
import come.amin.entity.Dependent;

import java.util.List;
import java.util.Optional;

public interface DependentService {
    public List<Dependent> findAll();
    public Optional<Dependent> findById(int id);
    public void save(Dependent dependent);
    public void deleteById (int id);
}
