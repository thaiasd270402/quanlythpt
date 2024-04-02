package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.sohocba;
import com.example.demo_qlhs_c3.repository.SoHocBaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoHocBaServiceImpl implements SoHocBaService{
    @Autowired
    private SoHocBaRepository soHocBaRepository;
    @Override
    public List<sohocba> getAllSoHocBa() {
        return soHocBaRepository.findAll();
    }

    @Override
    public sohocba getSoHocBaById(int id) {
        return soHocBaRepository.getById(id);
    }

    @Override
    public void saveSoHocBa(sohocba sohocba, int id) {
        sohocba.setId(id);
        soHocBaRepository.save(sohocba);
    }

    @Override
    public sohocba updateSoHocBa(sohocba sohocba) {
        return soHocBaRepository.saveAndFlush(sohocba);
    }

    @Override
    public void deleteSoHocBaById(int id) {
        soHocBaRepository.deleteById(id);
    }
}
