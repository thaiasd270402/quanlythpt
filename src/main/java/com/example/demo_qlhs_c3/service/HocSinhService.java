package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.hocsinh;

import java.util.List;

public interface HocSinhService {
    public void saveHocSinh (hocsinh hocsinh, int id);

    public List<hocsinh> getAllHocSinh();

    public hocsinh getHocSinhById(int id);

    public hocsinh updateHocSinh(hocsinh hocsinh);

    public void deleteHocSinhById(int id);

    public List<hocsinh> searchHocSinhByName(String name);


}
