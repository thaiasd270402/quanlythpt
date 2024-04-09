package com.example.demo_qlhs_c3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "giao_vien")
public class giaovien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ten_giao_vien")
    private String tenGiaoVien;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "dia_chi")
    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc")
    private monhoc monHoc;


    @OneToOne(mappedBy = "giaoVien")
    private lop lop;

    @OneToMany(mappedBy = "giaoVien")
    List<sodaubai> soDauBai;

    public giaovien() {
    }


    public com.example.demo_qlhs_c3.entity.lop getLop() {
        return lop;
    }

    public void setLop(com.example.demo_qlhs_c3.entity.lop lop) {
        this.lop = lop;
    }

    public monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(monhoc monHoc) {
        this.monHoc = monHoc;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<sodaubai> getSoDauBai() {
        return soDauBai;
    }

    public void setSoDauBai(List<sodaubai> soDauBai) {
        this.soDauBai = soDauBai;
    }
}
