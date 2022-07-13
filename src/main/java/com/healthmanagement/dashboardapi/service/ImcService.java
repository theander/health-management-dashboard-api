package com.healthmanagement.dashboardapi.service;

import com.healthmanagement.dashboardapi.model.Imc;
import com.healthmanagement.dashboardapi.repository.ImcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImcService  {
    @Autowired
    ImcRepository imcRepository;

    public  Imc create(Imc imc) {
        return imcRepository.save(imc);
    }

    public void update(Imc imc) {
        imcRepository.save(imc);
    }

    public List<Imc> findAll() {
        return imcRepository.findAll();
    }

    public Imc findOne() {
        Imc m = new Imc();
        m.setAltura(1.70f);
        m.setPeso(200f);
        return m;
    }

    public Imc findById(String id) {
        return imcRepository.findById(id).orElse(null);
    }

    public void deleteImc(Imc imc) {
        imcRepository.deleteById(imc.getId());
    }

    public Long countImc() {
        return imcRepository.count();
    }
}
