package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.thehocsinh;

import java.util.List;

public interface TheHocSinhService {
    public void saveTheHocSinh(thehocsinh thehocsinh);

    public List<thehocsinh> getAllTheHocSinh();

    public thehocsinh getTheHocSinhById(int id);

    public void updateTheHocSinh(thehocsinh thehocsinh, int id);

    public void deleteThHocSinhById(int id);

}
