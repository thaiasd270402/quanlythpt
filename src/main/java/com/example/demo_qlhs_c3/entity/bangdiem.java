package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bang_diem")
public class bangdiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "hoc_ky")
    private int hocKy;
    @Column(name = "diem_so")
    private float diemSo;
    @ManyToOne
    @JoinColumn(name = "id_hoc_sinh")
    private hocsinh hocSinh;
    @ManyToOne
    @JoinColumn(name = "id_mon_hoc")
    private monhoc monHoc;

    @ManyToOne
    @JoinColumn(name = "id_hoc_ba")
    private sohocba soHocBa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(float diemSo) {
        this.diemSo = diemSo;
    }

    public hocsinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(hocsinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    public monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(monhoc monHoc) {
        this.monHoc = monHoc;
    }

    public sohocba getSoHocBa() {
        return soHocBa;
    }

    public void setSoHocBa(sohocba soHocBa) {
        this.soHocBa = soHocBa;
    }
}
