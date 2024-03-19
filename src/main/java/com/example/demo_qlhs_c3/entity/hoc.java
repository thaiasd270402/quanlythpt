package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;
import com.example.demo_qlhs_c3.entity.keys.hoc_id;

@Entity
@Table(name = "hoc")
public class hoc {

    @EmbeddedId
    private hoc_id hocId;

    @ManyToOne
    @JoinColumn(name = "id_mon_hoc", insertable = false, updatable = false)
    private monhoc monHoc;
    @ManyToOne
    @JoinColumn(name = "id_hoc_sinh", insertable = false, updatable = false)
    private hocsinh hocSinh;

    public hoc_id getHocId() {
        return hocId;
    }

    public void setHocId(hoc_id hocId) {
        this.hocId = hocId;
    }

    public monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(monhoc monHoc) {
        this.monHoc = monHoc;
    }

    public hocsinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(hocsinh hocSinh) {
        this.hocSinh = hocSinh;
    }
}
