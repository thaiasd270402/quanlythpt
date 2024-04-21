package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.thehocsinh;
import org.springframework.stereotype.Repository;

@Repository
public interface TheHocSinhRepository extends JpaRepository<thehocsinh, Integer> {
}
