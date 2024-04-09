package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.entity.phieudiem;
import com.example.demo_qlhs_c3.repository.PhieuDiemRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuDIemServiceImpl implements PhieuDIemService {
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
    @Transactional
    public void savePhieuDiem(phieudiem phieudiem) {

        phieuDiemRepository.save(phieudiem);
    }

    @Override
    @Transactional
    public phieudiem updatePhieuDiem(phieudiem phieudiem, int id) {
        phieudiem.setId(id);
        return phieuDiemRepository.save(phieudiem);
    }

    @Override
    @Transactional
    public void deletePhieuDiemById(int id) {
        phieuDiemRepository.deleteById(id);
    }

    @Override
    public List<phieudiem> searchPhieuDiemByName(String name) {
        return phieuDiemRepository.serchPhieuDiemByName(name);
    }

    @Override
    public List<phieudiem> searchPhieuDiemInForm(String name, String monhoc) {
        return phieuDiemRepository.serchPhieuDiemInForm(name, monhoc);
    }
}
