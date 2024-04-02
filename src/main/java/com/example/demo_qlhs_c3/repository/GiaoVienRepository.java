package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.giaovien;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoVienRepository extends JpaRepository<giaovien, Integer> {
}
