package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "so_dau_bai")
public class sodaubai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ngay_giang_day")
    private Date ngayGiangDay;
    @Column(name = "noi_dung_giang_day")
    private String noiDungGiangDay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lop_hoc", referencedColumnName = "id")
    private lop lop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_giao_vien", referencedColumnName = "id")
    private giaovien giaoVien;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayGiangDay() {
        return ngayGiangDay;
    }

    public void setNgayGiangDay(Date ngayGiangDay) {
        this.ngayGiangDay = ngayGiangDay;
    }

    public String getNoiDungGiangDay() {
        return noiDungGiangDay;
    }

    public void setNoiDungGiangDay(String noiDungGiangDay) {
        this.noiDungGiangDay = noiDungGiangDay;
    }

    public com.example.demo_qlhs_c3.entity.lop getLop() {
        return lop;
    }

    public void setLop(com.example.demo_qlhs_c3.entity.lop lop) {
        this.lop = lop;
    }

    public giaovien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(giaovien giaoVien) {
        this.giaoVien = giaoVien;
    }
}
