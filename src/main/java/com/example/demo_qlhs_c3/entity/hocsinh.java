package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "hoc_sinh")
public class hocsinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ten_hoc_sinh")
    private String tenHocSinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "gioi_tinh")
    private String gioiTinh;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "nien_khoa")
    private String nienKhoa;

    @ManyToOne
    @JoinColumn(name = "id_lop", nullable = false)
    private lop lop;
    @OneToOne(mappedBy = "hocSinh")
    private thehocsinh theHocSinh;

    @OneToMany(mappedBy = "hocSinh")
    private List<bangdiem> bangDiem;

    @OneToOne(mappedBy = "hocSinh")
    private sohocba soHocBa;

    @OneToOne(mappedBy = "hocSinh")
    @PrimaryKeyJoinColumn
    private phuhuynh phuHuynh;

    @OneToMany(mappedBy = "hocSinh")
    private List<hoc> hoc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHocSinh() {
        return tenHocSinh;
    }

    public void setTenHocSinh(String tenHocSinh) {
        this.tenHocSinh = tenHocSinh;
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

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public com.example.demo_qlhs_c3.entity.lop getLop() {
        return lop;
    }

    public void setLop(com.example.demo_qlhs_c3.entity.lop lop) {
        this.lop = lop;
    }

    public thehocsinh getTheHocSinh() {
        return theHocSinh;
    }

    public void setTheHocSinh(thehocsinh theHocSinh) {
        this.theHocSinh = theHocSinh;
    }

    public List<bangdiem> getBangDiem() {
        return bangDiem;
    }

    public void setBangDiem(List<bangdiem> bangDiem) {
        this.bangDiem = bangDiem;
    }

    public phuhuynh getPhuHuynh() {
        return phuHuynh;
    }

    public void setPhuHuynh(phuhuynh phuHuynh) {
        this.phuHuynh = phuHuynh;
    }

    public List<com.example.demo_qlhs_c3.entity.hoc> getHoc() {
        return hoc;
    }

    public void setHoc(List<com.example.demo_qlhs_c3.entity.hoc> hoc) {
        this.hoc = hoc;
    }
}
