package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.entity.hocsinh;

import java.util.List;

@Controller
@RequestMapping("/hocsinh")
public class HocSinhController {

    @Autowired
    private HocSinhService hocSinhService;

    @Autowired
    private LopHocService lopHocService;

    @GetMapping("/list")
    public String list(Model model){
        List<hocsinh> hocsinh = hocSinhService.getAllHocSinh();
        model.addAttribute("hocsinhs", hocsinh);

        return ("hocsinh/hocsinh");

    }

    @GetMapping("/creat")
    public String creat(Model model){
        hocsinh hocsinh = new hocsinh();
        model.addAttribute("hocsinh", hocsinh);

        List<lop> listLop = lopHocService.getAllLopHoc();
        model.addAttribute("listLopHoc", listLop);

        return ("hocsinh/hocsinh-form");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("hocsinh") hocsinh hocsinh, @RequestParam("id") int id){
        hocSinhService.saveHocSinh(hocsinh, id);
        return "redirect:/hocsinh/list";

    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("id") int id){
        hocsinh hocsinh = hocSinhService.getHocSinhById(id);
        model.addAttribute("hocsinh", hocsinh);

        List<lop> listLop = lopHocService.getAllLopHoc();
        model.addAttribute("listLopHoc", listLop);
        return ("hocsinh/hocsinh-form");
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        hocSinhService.deleteHocSinhById(id);
        return "redirect:/hocsinh/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String name, Model model){
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        if(name!=null){
            hocsinhList = hocSinhService.searchHocSinhByName(name);
        }

        model.addAttribute("hocsinhs", hocsinhList);
        return ("hocsinh/hocsinh");
    }



}
