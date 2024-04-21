package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.phuhuynh;

import java.util.List;

public interface PhuHuynhService {
    public List<phuhuynh> getAllPhuHuynh();
    public void savePhuHuynh(phuhuynh phuhuynh);

    public phuhuynh getPhuHuynhById(int id);

    public List<phuhuynh> searchByPh(String name);

    public List<phuhuynh> searchByHs(String name);
    public List<phuhuynh> searchByPhAndHs(String name1, String name2);
}
