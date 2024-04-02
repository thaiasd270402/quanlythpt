package com.example.demo_qlhs_c3.service;

import com.example.demo_qlhs_c3.entity.monhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.giaovien;

import java.util.List;

public interface GiaoVienService {
    public void saveGiaoVien(giaovien giaovien, int id);

    public List<giaovien> getAllGiaoVien();

    public giaovien getGiaoVienById(int id);

    public giaovien updateGiaoVien(giaovien giaovien);

    public void deleteGiaoVienById(int id);
}
