package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "phieu_diem")
public class phieudiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ngay_kiem_tra")
    private Date ngayKiemTra;
    @Column(name = "diem_so")
    private float diemSo;
    @Column(name = "hoc_ky")
    private int hocKy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_hoc_sinh" ,referencedColumnName = "id")
    private hocsinh hocSinh;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mon_hoc", referencedColumnName = "id")
    private monhoc monHoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayKiemTra() {
        return ngayKiemTra;
    }

    public void setNgayKiemTra(Date ngayKiemTra) {
        this.ngayKiemTra = ngayKiemTra;
    }

    public float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(float diemSo) {
        this.diemSo = diemSo;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
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
}
