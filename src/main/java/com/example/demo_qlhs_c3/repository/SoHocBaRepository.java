package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.sohocba;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoHocBaRepository extends JpaRepository<sohocba, Integer> {


}
