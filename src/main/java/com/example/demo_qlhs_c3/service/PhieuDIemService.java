package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.phieudiem;

import java.util.List;

public interface PhieuDIemService {
    public List<phieudiem> getAllPhieuDiem();

    public phieudiem getPhieuDiemById(int id);

    public void savePhieuDiem(phieudiem phieudiem, int id);

    public phieudiem updatePhieuDiem(phieudiem phieudiem);

    public void deletePhieuDiemById(int id);

}
