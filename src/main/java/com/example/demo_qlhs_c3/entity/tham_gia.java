package com.example.demo_qlhs_c3.entity;
import com.example.demo_qlhs_c3.entity.keys.tham_gia_id;
import jakarta.persistence.*;

@Entity
@Table(name = "tham_gia")
public class tham_gia {
    @EmbeddedId
    private tham_gia_id thamGiaId;

    @ManyToOne
    @JoinColumn(name = "id_giao_vien", insertable = false, updatable = false)
    private giaovien giaoVien;
    @ManyToOne
    @JoinColumn(name = "id_lop_hoc", insertable = false, updatable = false)
    private monhoc monHoc;

    public tham_gia_id getThamGiaId() {
        return thamGiaId;
    }

    public void setThamGiaId(tham_gia_id thamGiaId) {
        this.thamGiaId = thamGiaId;
    }

    public giaovien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(giaovien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(monhoc monHoc) {
        this.monHoc = monHoc;
    }
}
