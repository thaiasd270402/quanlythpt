package com.example.demo_qlhs_c3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "the_hoc_sinh")
public class thehocsinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "anh_dai_dien")
    private String anhDaiDien;
    @OneToOne
    @JoinColumn(name = "id_hoc_sinh", referencedColumnName = "id")
    private hocsinh hocSinh;

    public thehocsinh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public hocsinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(hocsinh hocSinh) {
        this.hocSinh = hocSinh;
    }
}
