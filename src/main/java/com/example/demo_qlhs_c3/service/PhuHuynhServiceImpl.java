package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.phuhuynh;
import com.example.demo_qlhs_c3.repository.PhuHuynhRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhuHuynhServiceImpl implements PhuHuynhService {

    @Autowired
    private PhuHuynhRepository phuHuynhRepository;

    @Override
    public List<phuhuynh> getAllPhuHuynh() {
        return phuHuynhRepository.findAll();
    }

    @Override
    @Transactional
    public void savePhuHuynh( phuhuynh phuhuynh) {

        phuHuynhRepository.save(phuhuynh);
    }

    @Override
    @Transactional
    public phuhuynh getPhuHuynhById(int id) {
        return phuHuynhRepository.getById(id);
    }

    @Override
    public List<phuhuynh> searchByPh(String name) {
        return phuHuynhRepository.serchByNamePh(name);
    }

    @Override
    public List<phuhuynh> searchByHs(String name) {
        return phuHuynhRepository.serchByNameHs(name);
    }

    @Override
    public List<phuhuynh> searchByPhAndHs(String name1, String name2) {
        return phuHuynhRepository.serchByPhAndHs(name1, name2);
    }
}
