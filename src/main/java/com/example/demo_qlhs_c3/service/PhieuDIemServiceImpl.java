package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.phieudiem;
import com.example.demo_qlhs_c3.repository.PhieuDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuDIemServiceImpl implements PhieuDIemService{
    @Autowired
    private PhieuDiemRepository phieuDiemRepository;
    @Override
    public List<phieudiem> getAllPhieuDiem() {
        return phieuDiemRepository.findAll();
    }

    @Override
    public phieudiem getPhieuDiemById(int id) {
        return phieuDiemRepository.getById(id);
    }

    @Override
    public void savePhieuDiem(phieudiem phieudiem, int id) {
        phieudiem.setId(id);
        phieuDiemRepository.save(phieudiem);
    }

    @Override
    public phieudiem updatePhieuDiem(phieudiem phieudiem) {
        return phieuDiemRepository.saveAndFlush(phieudiem);
    }

    @Override
    public void deletePhieuDiemById(int id) {
        phieuDiemRepository.deleteById(id);
    }
}
