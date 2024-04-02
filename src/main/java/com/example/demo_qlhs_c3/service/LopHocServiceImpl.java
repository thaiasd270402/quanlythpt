package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.repository.LopHocRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopHocServiceImpl implements LopHocService{
    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private EntityManager entityManager;
    @Override
    @Transactional
    public void saveLopHoc(lop lop, int id) {

        lop.setId(id);
        lopHocRepository.save(lop);


//        if(!entityManager.contains(lop)){
//            lop manageLop = entityManager.merge(lop);
//            lopHocRepository.save(manageLop);
//        }else{
//
//            lopHocRepository.save(lop);
//        }
    }

    @Override
    public List<lop> getAllLopHoc() {
        return lopHocRepository.findAll();
    }

    @Override
    public lop getLopHocById(int id) {
        return lopHocRepository.getById(id);
    }

    @Override
    @Transactional
    public lop updateLopHoc(lop lop) {
        return lopHocRepository.saveAndFlush(lop);
    }

    @Override
    @Transactional
    public void deleteLopHocById(int id) {
        lopHocRepository.deleteById(id);
    }
}
