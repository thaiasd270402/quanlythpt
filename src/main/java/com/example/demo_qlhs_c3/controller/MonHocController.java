package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.GiaoVienService;
import com.example.demo_qlhs_c3.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.monhoc;
import com.example.demo_qlhs_c3.entity.giaovien;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;
    @Autowired
    private GiaoVienService giaoVienService;




    @GetMapping("/list")
    public String getAll(Model model){
        List<monhoc> list = monHocService.getAllMonHoc();
        int countMonHoc = list.size();
        model.addAttribute("countMonHoc", countMonHoc);
        model.addAttribute("monhocs", list);
        return "monhoc/monhoc";
    }

    @GetMapping("/creat")
    public String creat(Model model){
        monhoc monhoc  = new monhoc();
        model.addAttribute(monhoc);
        return"monhoc/monhoc-form";
    }


    @PostMapping("/save")
    public String save(@RequestParam("id") int id,  @ModelAttribute("monhoc") monhoc monhoc){

        monHocService.saveMonHoc(monhoc, id);
        return "redirect:/monhoc/list";

    }
    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model){
        monhoc monhoc = monHocService.getMonHocById(id);
        model.addAttribute("monhoc", monhoc);
        return"monhoc/monhoc-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        monHocService.deleteMonHocById(id);
        return "redirect:/monhoc/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model){
        monhoc monHoc = monHocService.getMonHocById(id);
        model.addAttribute("monhoc", monHoc);
        List<giaovien> giaovienList = giaoVienService.getAllGiaoVien();

        List<giaovien> giaoviens = new ArrayList<>();
        for(giaovien giaovien : giaovienList){
            if(monHoc.getId() == giaovien.getMonHoc().getId()){
                giaoviens.add(giaovien);
            }
        }

        model.addAttribute("giaoviens", giaoviens);

        return ("monhoc/monhoc-detail");
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/monhoc/list";
    }





}
