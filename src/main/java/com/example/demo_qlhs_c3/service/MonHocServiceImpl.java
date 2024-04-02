package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.monhoc;
import com.example.demo_qlhs_c3.repository.MonHocRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocServiceImpl implements MonHocService{
    private MonHocRepository monHocRepository;

    @Autowired
    public MonHocServiceImpl(MonHocRepository monHocRepository) {
        this.monHocRepository = monHocRepository;
    }

    @Override
    @Transactional
    public void saveMonHoc(monhoc monhoc, int id) {
        try {
            monhoc.setId(id);
            monHocRepository.save(monhoc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public List<monhoc> getAllMonHoc() {

        return monHocRepository.findAll();
    }

    @Override
    public monhoc getMonHocById(int id) {

        return monHocRepository.getById(id);
    }

    @Override
    @Transactional
    public monhoc updateMonHoc(monhoc monhoc) {

        return monHocRepository.saveAndFlush(monhoc);
    }

    @Override
    @Transactional
    public void deleteMonHocById(int id) {
        monHocRepository.deleteById(id);
    }
}
