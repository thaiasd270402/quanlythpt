package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.LopHocService;
import com.example.demo_qlhs_c3.service.SoDauBaiService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.entity.sodaubai;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sodaubai")
public class SoDauBaiController {

    @Autowired
    private SoDauBaiService soDauBaiService;

    @Autowired
    private LopHocService lopHocService;

    @PostConstruct
    public void set_sohocba_by_lop() {
        List<lop> lopList = lopHocService.getAllLopHoc();
        List<sodaubai> sodaubaiList = soDauBaiService.getAllSoDauBai();
        if (sodaubaiList.isEmpty()) {
            for (lop lop : lopList) {
                sodaubai sodaubai = new sodaubai();
                sodaubai.setLop(lop);
                sodaubai.setGiaoVien(lop.getGiaoVien());
                soDauBaiService.saveSoDauBai(sodaubai);
            }
        }

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<lop> lopList = lopHocService.getAllLopHoc();
        List<sodaubai> sodaubaiList = soDauBaiService.getAllSoDauBai();
        for (lop lop1 : lopList) {
            boolean flag = false;
            for (sodaubai sodaubai1 : sodaubaiList) {
                if (lop1.getId() == sodaubai1.getLop().getId()) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                sodaubai sodaubai = new sodaubai();
                sodaubai.setLop(lop1);
                soDauBaiService.saveSoDauBai(sodaubai);
            }
        }


        model.addAttribute("lopList", lopList);
        return ("sodaubai/sodaubai-list-by-lophoc");
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int idLop, Model model) {
        List<sodaubai> sodaubaiList = soDauBaiService.getAllSoDauBai();
        List<sodaubai> sodaubais = new ArrayList<>();
        for (sodaubai sodaubai1 : sodaubaiList) {
            if (sodaubai1.getLop().getId() == idLop) {
                sodaubais.add(sodaubai1);
            }
        }


        model.addAttribute("sodaubais", sodaubais);
        return ("sodaubai/sodaubai-detail");


    }

    @GetMapping("/save")
    public String save( Model model) {
        sodaubai sodaubai = new sodaubai();
        model.addAttribute("sodaubai", sodaubai);
     return ("sodaubai/sodaubai-form-save");
    }

}
