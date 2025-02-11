package com.example.api02_monumentos.services;

import com.example.api02_monumentos.error.MonumentBadRequestException;
import com.example.api02_monumentos.error.MonumentNotFoundException;
import com.example.api02_monumentos.models.Monument;
import com.example.api02_monumentos.repositories.MonumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MonumentService {

    @Autowired
    private MonumentRepository monuRepo;


    public List<Monument> getAll() {
        List<Monument> list = monuRepo.getAll();
        if (list.isEmpty())
            throw new MonumentNotFoundException();
        return list;
    }

    public List<Monument> query(String countryCode, String sortDirection) {
        List<Monument> result = monuRepo.query(countryCode, sortDirection);
        if (result.isEmpty())
            throw new MonumentNotFoundException();
        return result;
    }

    public Monument getMonument(long id) {
        return monuRepo.findById(id).orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public Monument addMonument(Monument m) {
        //if(m.getId() == null) {
            return monuRepo.addMonument(m);
        /*} else {
            throw new MonumentBadRequestException();
        }*/
    }

    public Monument edit(Long id, Monument newValue) {
        return monuRepo.editMonument(id, newValue)
                .orElseThrow(() -> new MonumentNotFoundException(id));
    }

    public void delete(Long id) {
        monuRepo.deleteMonument(id);
    }
}
