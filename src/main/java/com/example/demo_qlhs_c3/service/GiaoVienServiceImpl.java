package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.giaovien;
import com.example.demo_qlhs_c3.repository.GiaoVienRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoVienServiceImpl implements GiaoVienService{

    @Autowired
    private GiaoVienRepository giaoVienRepository;

    @Override
    @Transactional
    public void saveGiaoVien(giaovien giaovien, int id) {
        try {
            giaovien.setId(id);
            giaoVienRepository.save(giaovien);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<giaovien> getAllGiaoVien() {
        return giaoVienRepository.findAll();
    }

    @Override
    public giaovien getGiaoVienById(int id) {
        return giaoVienRepository.getById(id);
    }

    @Override
    @Transactional
    public giaovien updateGiaoVien(giaovien giaovien) {
        return giaoVienRepository.saveAndFlush(giaovien);
    }

    @Override
    @Transactional
    public void deleteGiaoVienById(int id) {
        giaoVienRepository.deleteById(id);
    }
}
