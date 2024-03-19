package com.example.demo_qlhs_c3.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;

@Embeddable
public class tham_gia_id implements Serializable {

    @Column(name = "id_giao_vien")
    private int giaoVienId;
    @Column(name = "id_lop_hoc")
    private int lopHocId;

    public tham_gia_id() {
    }

    public tham_gia_id(int giaoVienId, int lopHocId) {
        this.giaoVienId = giaoVienId;
        this.lopHocId = lopHocId;
    }

    public int getGiaoVienId() {
        return giaoVienId;
    }

    public void setGiaoVienId(int giaoVienId) {
        this.giaoVienId = giaoVienId;
    }

    public int getLopHocId() {
        return lopHocId;
    }

    public void setLopHocId(int lopHocId) {
        this.lopHocId = lopHocId;
    }
}
