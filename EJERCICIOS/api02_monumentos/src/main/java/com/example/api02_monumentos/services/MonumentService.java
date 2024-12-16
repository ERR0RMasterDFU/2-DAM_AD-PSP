package com.example.api02_monumentos.services;

import com.example.api02_monumentos.error.MonumentNotFoundException;
import com.example.api02_monumentos.models.Monument;
import com.example.api02_monumentos.repositories.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MonumentService {

    @Autowired
    private MonumentRepository monuRepo;

    private final ArrayList<Monument> monumentsList = new ArrayList<>();

    public Monument addMonument(Monument m) {
        return monuRepo.save(m);
    }

    public Monument getMonument(long id) {
        return monuRepo.findById(id).orElseThrow(() -> new MonumentNotFoundException(id));
    }

    /*public List<Monument> getAllMonuments() {
        return List.copyOf(monuRepo.findAll());
    }*/

    public Monument editMonument(Monument m, long id) {

        Monument nuevo = null;
        Monument old = this.getMonument(id);

        if(this.getMonument(id).equals()) {
            nuevo = monuRepo.save(m);
            return nuevo;
        } else {
            return this.getMonument(id).orElseThrow(() -> new MonumentNotFoundException(id));
        }

    }

    public void deleteMonument(Long id) {
        monuRepo.deleteById(id);
    }

    public List<Monument> getAllMonuments(String countryName, String sortDirection) {
        List<Monument> data = new ArrayList<>(monuRepo.findAll());
        List<Monument> result;

        if (countryName.isBlank()) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getCountryName().equals(countryName))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monument::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monument::getName).reversed());

        return List.copyOf(Collections.unmodifiableList(result));
    }

}
