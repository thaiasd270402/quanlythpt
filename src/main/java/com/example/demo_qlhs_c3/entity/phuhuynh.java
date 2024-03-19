package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "phu_huynh")
public class phuhuynh {
    @Id
    @Column(name = "id_hoc_sinh")
    private int idHocSinh;
    @Column(name = "ten_phu_huynh")
    private String tenPhuHuynh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "que_quan")
    private String queQuan;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "sdt")
    private String soDienThoai;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_hoc_sinh")
    private hocsinh hocSinh;

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getTenPhuHuynh() {
        return tenPhuHuynh;
    }

    public void setTenPhuHuynh(String tenPhuHuynh) {
        this.tenPhuHuynh = tenPhuHuynh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public hocsinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(hocsinh hocSinh) {
        this.hocSinh = hocSinh;
    }
}
