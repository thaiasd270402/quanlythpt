package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mon_hoc")
public class monhoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ten_mon_hoc")
    private String tenMonHoc;

    @OneToMany(mappedBy = "monHoc")
    private List<giaovien> giaoVien;


    @OneToMany(mappedBy = "monHoc")
    private List<phieudiem>  phieuDiem;




    public monhoc() {
    }

    public monhoc(int id, String tenMonHoc, List<giaovien> giaoVien) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.giaoVien = giaoVien;



    }

    public monhoc(String tenMonHoc, List<giaovien> giaoVien) {
        this.tenMonHoc = tenMonHoc;
        this.giaoVien = giaoVien;



    }

    public List<phieudiem> getPhieuDiem() {
        return phieuDiem;
    }

    public void setPhieuDiem(List<phieudiem> phieuDiem) {
        this.phieuDiem = phieuDiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public List<giaovien> getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(List<giaovien> giaoVien) {
        this.giaoVien = giaoVien;
    }




}
