package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.hocsinh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocSinhRepository extends JpaRepository<hocsinh, Integer> {
//    @Query("SELECT c FROM hocsinh c WHERE c.tenHocSinh LIKE %:name%")
@Query("SELECT c FROM hocsinh c " +
        "WHERE LOWER(c.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) " +
//        "OR function('date_format', s.ngaySinh, '%Y, %m, %d') LIKE LOWER(CONCAT('%', :name, '%')) " +
        "OR LOWER(c.gioiTinh) LIKE LOWER(CONCAT('%', :name, '%')) " +
        "OR LOWER(c.diaChi) LIKE LOWER(CONCAT('%', :name, '%')) " +
        "OR LOWER(c.nienKhoa) LIKE LOWER(CONCAT('%', :name, '%')) " +
        "OR LOWER(c.lop.tenLop) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<hocsinh> serchHocSinhByName(String name);
}
