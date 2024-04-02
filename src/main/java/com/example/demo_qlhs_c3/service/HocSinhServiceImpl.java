package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.repository.HocSinhRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocSinhServiceImpl implements HocSinhService{
    @Autowired
    private HocSinhRepository hocSinhRepository;

    @Override
    @Transactional
    public void saveHocSinh(hocsinh hocsinh, int id) {
        hocsinh.setId(id);
        hocSinhRepository.save(hocsinh);
    }

    @Override
    public List<hocsinh> getAllHocSinh() {
        return hocSinhRepository.findAll();
    }

    @Override
    public hocsinh getHocSinhById(int id) {
        return hocSinhRepository.getById(id);
    }

    @Override
    @Transactional
    public hocsinh updateHocSinh(hocsinh hocsinh) {
        return hocSinhRepository.saveAndFlush(hocsinh);
    }

    @Override
    @Transactional
    public void deleteHocSinhById(int id) {
        hocSinhRepository.deleteById(id);
    }

    @Override
    public List<hocsinh> searchHocSinhByName(String name) {
        return hocSinhRepository.serchHocSinhByName(name);
    }
}
