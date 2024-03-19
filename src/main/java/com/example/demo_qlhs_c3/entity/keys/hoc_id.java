package com.example.demo_qlhs_c3.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class hoc_id implements Serializable {
    @Column(name = "id_mon_hoc")
    private int monHoc;
    @Column(name = "id_hoc_sinh")
    private int hocSinh;

    public hoc_id() {
    }

    public hoc_id(int monHoc, int hocSinh) {
        this.monHoc = monHoc;
        this.hocSinh = hocSinh;
    }

    public int getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(int monHoc) {
        this.monHoc = monHoc;
    }

    public int getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(int hocSinh) {
        this.hocSinh = hocSinh;
    }
}
