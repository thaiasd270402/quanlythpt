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

public List<phieudiem> serchPhieuDiemByTenHocSinh(String name);
    public List<phieudiem> serchPhieuDiemByLop(String name);
    public List<phieudiem> serchPhieuDiemByMonHoc(String name);

    public List<phieudiem> serchPhieuDiemByTenHocSinhAndLop(String name, String name2);
    public List<phieudiem> serchPhieuDiemByTenHocSinhAndMonHoc(String name, String name2);
    public List<phieudiem> serchPhieuDiemByTenLopAndMonHoc(String name, String name2);
    public List<phieudiem> serchPhieuDiemByTenHocSinh_Lop_MonHoc(String name, String name2, String name3);




}
