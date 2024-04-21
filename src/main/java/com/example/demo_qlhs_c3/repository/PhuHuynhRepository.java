package com.example.demo_qlhs_c3.repository;

import com.example.demo_qlhs_c3.entity.hocsinh;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_qlhs_c3.entity.phuhuynh;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhuHuynhRepository extends JpaRepository<phuhuynh, Integer> {
    //tìm kiếm này dành cho form sohocba
    @Query("SELECT c FROM phuhuynh c " +
            "WHERE LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name, '%')) ")
    public List<phuhuynh> serchByNameHs(String name);

    //tìm kiếm này dành cho form sohocba
    @Query("SELECT c FROM phuhuynh c " +
            "WHERE LOWER(c.tenPhuHuynh) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<phuhuynh> serchByNamePh(String name);

    //tìm kiếm này dành cho form sohocba
    @Query("SELECT c FROM phuhuynh c " +
            "WHERE (LOWER(c.hocSinh.tenHocSinh) LIKE LOWER(CONCAT('%', :name1, '%')) AND LOWER(c.tenPhuHuynh) LIKE LOWER(CONCAT('%', :name2, '%')) )")
    public List<phuhuynh> serchByPhAndHs(String name1, String name2);
}
