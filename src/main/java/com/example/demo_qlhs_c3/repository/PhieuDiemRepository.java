package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.phieudiem;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDiemRepository extends JpaRepository<phieudiem, Integer> {
}
