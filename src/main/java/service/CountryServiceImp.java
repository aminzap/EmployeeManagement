package service;

import come.amin.entity.Country;
import org.springframework.stereotype.Service;
import repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService{
    CountryRepository countryRepository;

    public CountryServiceImp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(int id) {
        if (countryRepository.findById(id).isPresent()){
            return countryRepository.findById(id);
        }else {
            throw new RuntimeException("This id is not valid for finding: "+id);
        }
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteById(int id) {
        if(countryRepository.findById(id).isPresent()){
            countryRepository.deleteById(id);
        }else {
            throw  new RuntimeException("This id is not valid for deleting "+id);
        }
    }
}
