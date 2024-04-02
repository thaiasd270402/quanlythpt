package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.lop;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocRepository extends JpaRepository<lop, Integer> {
}
