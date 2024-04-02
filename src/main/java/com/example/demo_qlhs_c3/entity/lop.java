package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lop")
public class lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ten_lop")
    private String tenLop;
    @Column(name = "khoi_hoc")
    private String khoiHoc;

    @Column(name = "si_so")
    private int siSo;



    @OneToOne
    @JoinColumn(name = "id_giao_vien", referencedColumnName = "id")
    private giaovien giaoVien;

    @OneToOne(mappedBy = "lop")
    private sodaubai soDauBai;

    @OneToMany(mappedBy = "lop")
    private List<hocsinh> hocSinh;


    public lop() {
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public giaovien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(giaovien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public sodaubai getSoDauBai() {
        return soDauBai;
    }

    public void setSoDauBai(sodaubai soDauBai) {
        this.soDauBai = soDauBai;
    }

    public List<hocsinh> getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(List<hocsinh> hocSinh) {
        this.hocSinh = hocSinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoiHoc() {
        return khoiHoc;
    }

    public void setKhoiHoc(String khoiHoc) {
        this.khoiHoc = khoiHoc;
    }
}
