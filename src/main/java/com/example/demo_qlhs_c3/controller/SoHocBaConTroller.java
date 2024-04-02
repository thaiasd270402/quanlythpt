package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.SoHocBaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo_qlhs_c3.entity.sohocba;
import com.example.demo_qlhs_c3.entity.hocsinh;

import java.util.List;

@Controller
@RequestMapping("/sohocba")
public class SoHocBaConTroller {
    @Autowired
    private SoHocBaService soHocBaService;

    @Autowired
    private HocSinhService hocSinhService;

    @GetMapping("/list")
    public String list(Model model){
       List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();

       model.addAttribute("listHocSinh",hocsinhList);

       return ("sohocba/sohocba");
    }
}
