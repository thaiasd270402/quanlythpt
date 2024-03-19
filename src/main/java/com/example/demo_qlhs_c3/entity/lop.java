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
    private int khoiHoc;

    @OneToOne(mappedBy = "lop")
    private sodaubai soDauBai;

    @OneToMany(mappedBy = "lop")
    private List<hocsinh> hocSinh;

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

    public int getKhoiHoc() {
        return khoiHoc;
    }

    public void setKhoiHoc(int khoiHoc) {
        this.khoiHoc = khoiHoc;
    }
}
