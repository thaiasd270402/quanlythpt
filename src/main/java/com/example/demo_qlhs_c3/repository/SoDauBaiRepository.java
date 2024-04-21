package com.example.demo_qlhs_c3.repository;

import com.example.demo_qlhs_c3.entity.phieudiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo_qlhs_c3.entity.sodaubai;

import java.sql.Date;
import java.util.List;

@Repository
public interface SoDauBaiRepository extends JpaRepository<sodaubai, Integer> {

//    @Query("SELECT s FROM sodaubai s WHERE FUNCTION('DATE_FORMAT', s.ngayGiangDay, '%Y, %m, %d') = :name")
//
//    public List<sodaubai> serchSdbByDate(String name);
}
