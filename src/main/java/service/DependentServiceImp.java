package service;

import come.amin.entity.Dependent;
import repository.DependentRepository;

import java.util.List;
import java.util.Optional;

public class DependentServiceImp implements DependentService {
    DependentRepository dependentRepository;

    public DependentServiceImp(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @Override
    public List<Dependent> findAll() {
        return dependentRepository.findAll();
    }

    @Override
    public Optional<Dependent> findById(int id) {
        if (dependentRepository.findById(id).isPresent()){
            return dependentRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Dependent dependent) {
        dependentRepository.save(dependent);
    }

    @Override
    public void deleteById(int id) {
        if (dependentRepository.findById(id).isPresent()){
            dependentRepository.deleteById(id);
        }else {
            throw new RuntimeException("This id is not valid for deleting: "+id);
        }
    }
}
