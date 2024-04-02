package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.service.GiaoVienService;
import com.example.demo_qlhs_c3.service.LopHocService;
import com.example.demo_qlhs_c3.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.giaovien;
import com.example.demo_qlhs_c3.entity.monhoc;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/giaovien")
public class GiaoVienController {
    private GiaoVienService giaoVienService;
    private MonHocService monHocService;

    private LopHocService lopHocService;

    @Autowired
    public GiaoVienController(GiaoVienService giaoVienService, MonHocService monHocService, LopHocService lopHocService) {
        this.giaoVienService = giaoVienService;
        this.monHocService = monHocService;
        this.lopHocService = lopHocService;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        List<giaovien> list = giaoVienService.getAllGiaoVien();
       model.addAttribute("giaoviens",list);

        List<lop> lophocs =  lopHocService.getAllLopHoc();
        List<giaovien> listGiaoVien = giaoVienService.getAllGiaoVien();
        List<giaovien> listGiaoVien1 = new ArrayList<>(listGiaoVien);
        for (lop lop : lophocs) {
            for (giaovien giaoVien : listGiaoVien) {
                if (giaoVien.getId() == lop.getGiaoVien().getId()) {
                    listGiaoVien1.remove(giaoVien);
                }
            }
        }

        model.addAttribute("listGiaoVien", listGiaoVien1);
        return ("giaovien/giaovien");
    }

    @GetMapping("/creat")
    public String creat(Model model){
        giaovien giaovien = new giaovien();
        model.addAttribute("giaovien", giaovien);

        List<monhoc> listMonHoc = monHocService.getAllMonHoc();
        model.addAttribute("listMonHoc", listMonHoc);
        return ("giaovien/giaovien-form");

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("giaovien") giaovien giaovien, @RequestParam("id") int id){

        giaoVienService.saveGiaoVien(giaovien, id);
        return ("redirect:/giaovien/list");
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model){
        giaovien giaovien = giaoVienService.getGiaoVienById(id);
        model.addAttribute("giaovien",giaovien);

        List<monhoc> listMonHoc = monHocService.getAllMonHoc();
        model.addAttribute("listMonHoc", listMonHoc);
        return ("giaovien/giaovien-form");
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        giaoVienService.deleteGiaoVienById(id);

        return "redirect:/giaovien/list";
    }

}
