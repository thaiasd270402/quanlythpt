package com.example.demo_qlhs_c3.service;
import com.example.demo_qlhs_c3.entity.monhoc;

import java.util.List;

public interface MonHocService {


        public void saveMonHoc(monhoc monhoc, int id);

        public List<monhoc> getAllMonHoc();

        public monhoc getMonHocById(int id);

        public monhoc updateMonHoc(monhoc monhoc);

        public void deleteMonHocById(int id);



}
