package com.example.demo_qlhs_c3.service;

import java.util.List;
import com.example.demo_qlhs_c3.entity.sohocba;
public interface SoHocBaService {
    public List<sohocba> getAllSoHocBa();

    public sohocba getSoHocBaById(int id);

    public void updateSoHocBa(sohocba sohocba, int id);

    public sohocba saveSoHocBa(sohocba sohocba);

    public void deleteSoHocBaById(int id);
}
