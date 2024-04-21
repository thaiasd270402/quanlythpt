package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.sodaubai;
import com.example.demo_qlhs_c3.repository.SoDauBaiRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SoDauBaiSerViceImpl implements SoDauBaiService{

    @Autowired
    private SoDauBaiRepository soDauBaiRepository;
    @Override
    public List<sodaubai> getAllSoDauBai() {
        return soDauBaiRepository.findAll();
    }

    @Override
    public sodaubai getSoDauBaiById(int id) {
        return soDauBaiRepository.getById(id);
    }

    @Override
    @Transactional
    public void saveSoDauBai(sodaubai sodaubai) {
        soDauBaiRepository.save(sodaubai);
    }

    @Override
    @Transactional
    public sodaubai updateSoDauBai(sodaubai sodaubai, int id) {
        sodaubai.setId(id);
        return soDauBaiRepository.save(sodaubai);
    }

    @Override
    @Transactional
    public void deleteSoDauBaiById(int id) {
        soDauBaiRepository.deleteById(id);
    }


}
