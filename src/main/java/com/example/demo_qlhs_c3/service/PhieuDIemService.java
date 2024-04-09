package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.entity.phieudiem;

import java.util.List;

public interface PhieuDIemService {
    public List<phieudiem> getAllPhieuDiem();

    public phieudiem getPhieuDiemById(int id);

    public void savePhieuDiem(phieudiem phieudiem);

    public phieudiem updatePhieuDiem(phieudiem phieudiem, int id);

    public void deletePhieuDiemById(int id);

    public List<phieudiem> searchPhieuDiemByName(String name);

    public List<phieudiem> searchPhieuDiemInForm(String name, String monhoc);




}
