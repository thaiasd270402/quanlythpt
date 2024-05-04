package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.entity.giaovien;
import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.entity.sodaubai;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lophoc")
public class LopHocController {
    @Autowired
    private LopHocService lopHocService;

    @Autowired
    private GiaoVienService giaoVienService;

    @Autowired
    private HocSinhService hocSinhService;

    @Autowired
    private SoDauBaiService soDauBaiService;

    @GetMapping("/list")
    public String list(Model model) {

        List<lop> lophocs = lopHocService.getAllLopHoc();
        List<hocsinh> hocsinhs = hocSinhService.getAllHocSinh();
        for (lop lop1 : lophocs){
            int numHs=0;
            for (hocsinh hocsinh1 : hocsinhs){
                if(hocsinh1.getLop().getId()==lop1.getId()){
                    numHs+=1;
                }
            }
            lop1.setSiSo(numHs);
            int id = lop1.getId();
            lopHocService.saveLopHoc(lop1, id);
        }
        model.addAttribute("lophocs", lophocs);

        List<lop> lopList = lopHocService.getAllLopHoc();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        List<sodaubai> sodaubaiList = soDauBaiService.getAllSoDauBai();
        List<lop> lopList1 = new ArrayList<>(lopList);
        for (hocsinh hocsinh1 : hocsinhList){
            for (sodaubai sodaubai1 : sodaubaiList){
                for (lop lop1 : lopList){
                    if(hocsinh1.getLop().getId()==lop1.getId() || lop1.getId()==sodaubai1.getLop().getId()){
                        lopList1.remove(lop1);
                    }
                }
            }
        }
        model.addAttribute("lopList", lopList1);
        return ("lophoc/lophoc");
    }

    @GetMapping("/creat")
    public String create(Model model) {
        lop lophoc = new lop();
        model.addAttribute("lophoc", lophoc);

        List<lop> lophocs = lopHocService.getAllLopHoc();
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
        return ("lophoc/lophoc-form");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("lophoc") lop lop, @RequestParam("id") int id) {
        lopHocService.saveLopHoc(lop, id);

        return "redirect:/lophoc/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        lop lophoc = lopHocService.getLopHocById(id);
        model.addAttribute("lophoc", lophoc);

        List<lop> lophocs = lopHocService.getAllLopHoc();
        List<giaovien> listGiaoVien = giaoVienService.getAllGiaoVien();
//        List<giaovien> listGiaoVien1 = listGiaoVien;
        List<giaovien> listGiaoVien1 = new ArrayList<>(listGiaoVien);

        for (lop lop : lophocs) {
            for (giaovien giaoVien : listGiaoVien) {
                if (giaoVien.getId() == lop.getGiaoVien().getId()) {
                    listGiaoVien1.remove(giaoVien);
                }
            }
        }


        model.addAttribute("listGiaoVien", listGiaoVien1);
        return ("lophoc/lophoc-form");

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        lopHocService.deleteLopHocById(id);

        return "redirect:/lophoc/list";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id){
        List<hocsinh> listHocSinh = hocSinhService.getAllHocSinh();
        lop lopHoc = lopHocService.getLopHocById(id);

        List<hocsinh> listHocSinh1 = new ArrayList<>();
        for (hocsinh hocsinh : listHocSinh){
            if(hocsinh.getLop().getId()==lopHoc.getId()){
                listHocSinh1.add(hocsinh);
            }
        }

        model.addAttribute("hocsinhs", listHocSinh1);
        model.addAttribute("lopHoc", lopHoc);

        return ("lophoc/lophoc-detail");


    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/lophoc/list";
    }

}
