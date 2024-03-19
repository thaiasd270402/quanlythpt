package com.example.demo_qlhs_c3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo_qlhs_c3.entity.monhoc;

@Repository
public interface UserRepository extends JpaRepository<monhoc, Integer > {
}
