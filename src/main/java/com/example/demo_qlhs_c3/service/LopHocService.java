package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.monhoc;
import com.example.demo_qlhs_c3.entity.lop;

import java.util.List;

public interface LopHocService {
    public void saveLopHoc(lop lop, int id);

    public List<lop> getAllLopHoc();

    public lop getLopHocById(int id);

    public lop updateLopHoc(lop lop);

    public void deleteLopHocById(int id);

    public List<lop> serchByTenLop(String name);
}
