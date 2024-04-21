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

    @Override
    public List<phieudiem> serchPhieuDiemByTenHocSinh(String name) {
        return phieuDiemRepository.serchPhieuDiemByTenHocSinh(name);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByLop(String name) {
        return phieuDiemRepository.serchPhieuDiemByLop(name);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByMonHoc(String name) {
        return phieuDiemRepository.serchPhieuDiemByMonHoc(name);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByTenHocSinhAndLop(String name, String name2) {
        return phieuDiemRepository.serchPhieuDiemByTenHocSinhAndLop(name, name2);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByTenHocSinhAndMonHoc(String name, String name2) {
        return phieuDiemRepository.serchPhieuDiemByTenHocSinhAndMonHoc(name, name2);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByTenLopAndMonHoc(String name, String name2) {
        return phieuDiemRepository.serchPhieuDiemByTenLopAndMonHoc(name, name2);
    }

    @Override
    public List<phieudiem> serchPhieuDiemByTenHocSinh_Lop_MonHoc(String name, String name2, String name3) {
        return phieuDiemRepository.serchPhieuDiemByTenHocSinh_Lop_MonHoc(name, name2, name3);
    }
}
