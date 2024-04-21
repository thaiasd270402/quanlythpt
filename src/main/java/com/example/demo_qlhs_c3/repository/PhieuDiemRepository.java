package com.example.demo_qlhs_c3.repository;

import com.example.demo_qlhs_c3.entity.hocsinh;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.phieudiem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDiemRepository extends JpaRepository<phieudiem, Integer> {
    @Query("SELECT c FROM phieudiem c " +
//        "OR function('date_format', s.ngaySinh, '%Y, %m, %d') LIKE LOWER(CONCAT('%', :name, '%')) " +
            "WHERE LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name, '%'))" +
            "OR LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%'))" +
            "OR LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :name, '%'))"
//            "OR c.diemSo = CAST(:name AS double)" +
//            "OR c.hocKy = CAST(:name AS integer)"
    )
    public List<phieudiem> serchPhieuDiemByName(String name);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :monhoc, '%')) )" +
            "OR (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :monhoc, '%')) )"
    )
    public List<phieudiem> serchPhieuDiemInForm(String name, String monhoc);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) )"
    )
    public List<phieudiem> serchPhieuDiemByTenHocSinh(String name);


    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name, '%')) )"
    )
    public List<phieudiem> serchPhieuDiemByLop(String name);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :name, '%')) )"
    )
    public List<phieudiem> serchPhieuDiemByMonHoc(String name);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name2, '%')) )"

    )
    public List<phieudiem> serchPhieuDiemByTenHocSinhAndLop(String name, String name2);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :name2, '%')) )"

    )
    public List<phieudiem> serchPhieuDiemByTenHocSinhAndMonHoc(String name, String name2);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :name2, '%')) )"

    )
    public List<phieudiem> serchPhieuDiemByTenLopAndMonHoc(String name, String name2);

    @Query("SELECT c FROM phieudiem c " +
            "WHERE (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name2, '%')) AND LOWER(c.monHoc.tenMonHoc) LIKE LOWER(CONCAT('%', :name3, '%')))"

    )
    public List<phieudiem> serchPhieuDiemByTenHocSinh_Lop_MonHoc(String name, String name2, String name3);

}
