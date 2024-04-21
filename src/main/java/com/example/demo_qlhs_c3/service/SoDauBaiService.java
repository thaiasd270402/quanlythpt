package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.sodaubai;

import java.sql.Date;
import java.util.List;

public interface SoDauBaiService {
    public List<sodaubai> getAllSoDauBai();

    public sodaubai getSoDauBaiById(int id);

    public void saveSoDauBai(sodaubai sodaubai);

    public sodaubai updateSoDauBai(sodaubai sodaubai, int id);

    public void deleteSoDauBaiById(int id);


}
