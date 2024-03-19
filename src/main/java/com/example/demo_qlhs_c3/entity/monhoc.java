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
    private List<bangdiem> bangDiem;

    @OneToMany(mappedBy = "monHoc")
    private List<tham_gia> thamGia;

    @OneToMany(mappedBy = "monHoc")
    private List<hoc> hoc;

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

    public List<bangdiem> getBangDiem() {
        return bangDiem;
    }

    public void setBangDiem(List<bangdiem> bangDiem) {
        this.bangDiem = bangDiem;
    }

    public List<tham_gia> getThamGia() {
        return thamGia;
    }

    public void setThamGia(List<tham_gia> thamGia) {
        this.thamGia = thamGia;
    }

    public List<com.example.demo_qlhs_c3.entity.hoc> getHoc() {
        return hoc;
    }

    public void setHoc(List<com.example.demo_qlhs_c3.entity.hoc> hoc) {
        this.hoc = hoc;
    }
}
