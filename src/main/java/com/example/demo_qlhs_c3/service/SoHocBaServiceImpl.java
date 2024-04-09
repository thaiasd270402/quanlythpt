package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.sohocba;
import com.example.demo_qlhs_c3.repository.SoHocBaRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void updateSoHocBa(sohocba sohocba, int id) {
        sohocba.setId(id);
        soHocBaRepository.save(sohocba);
    }

    @Override
    @Transactional
    public sohocba saveSoHocBa(sohocba sohocba) {
        return soHocBaRepository.saveAndFlush(sohocba);
    }

    @Override
    @Transactional
    public void deleteSoHocBaById(int id) {
        soHocBaRepository.deleteById(id);
    }
}
