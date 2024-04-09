package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "so_hoc_ba")
public class sohocba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "diem_trung_binh")
    private Float diemTrungBinh;
    @Column(name = "hoc_luc")
    private String hocLuc;
    @Column(name = "hanh_kiem")
    private String hanhKiem;
    @Column(name = "nhan_xet_cua_giao_vien")
    private String nhanXetCuaGiaoVien;
    @OneToOne
    @JoinColumn(name = "id_hoc_sinh", referencedColumnName = "id")
    private hocsinh hocSinh;


    public sohocba() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public String getNhanXetCuaGiaoVien() {
        return nhanXetCuaGiaoVien;
    }

    public void setNhanXetCuaGiaoVien(String nhanXetCuaGiaoVien) {
        this.nhanXetCuaGiaoVien = nhanXetCuaGiaoVien;
    }

    public hocsinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(hocsinh hocSinh) {
        this.hocSinh = hocSinh;
    }


    public Float getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(Float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }
}
