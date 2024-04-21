package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.thehocsinh;
import com.example.demo_qlhs_c3.repository.TheHocSinhRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheHocSinhServiceImpl implements TheHocSinhService{

    @Autowired
    private TheHocSinhRepository theHocSinhRepository;
    @Override
    @Transactional
    public void saveTheHocSinh(thehocsinh thehocsinh) {
        theHocSinhRepository.save(thehocsinh);
    }

    @Override
    public List<thehocsinh> getAllTheHocSinh() {
        return theHocSinhRepository.findAll();
    }

    @Override
    public thehocsinh getTheHocSinhById(int id) {
        return theHocSinhRepository.getById(id);
    }

    @Override
    @Transactional
    public void updateTheHocSinh(thehocsinh thehocsinh, int id) {
        thehocsinh.setId(id);
        theHocSinhRepository.save(thehocsinh);
    }

    @Override
    @Transactional
    public void deleteThHocSinhById(int id) {
        theHocSinhRepository.deleteById(id);
    }
}
