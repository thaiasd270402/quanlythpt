package com.example.demo_qlhs_c3.repository;

import com.example.demo_qlhs_c3.entity.hocsinh;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.lop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopHocRepository extends JpaRepository<lop, Integer> {
    @Query("SELECT c FROM lop c " +
            "WHERE LOWER(c.tenLop) LIKE LOWER(CONCAT('%', :name, '%')) ")
    public List<lop> serchByTenLop(String name);
}
