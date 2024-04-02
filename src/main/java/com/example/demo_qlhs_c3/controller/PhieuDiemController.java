package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.MonHocService;
import com.example.demo_qlhs_c3.service.PhieuDIemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo_qlhs_c3.entity.phieudiem;
import com.example.demo_qlhs_c3.entity.monhoc;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo_qlhs_c3.entity.hocsinh;

import java.util.List;

@Controller
@RequestMapping("/phieudiem")
public class PhieuDiemController {
    @Autowired
    private PhieuDIemService phieuDiemService;

    @Autowired
    private MonHocService monHocService;

    @Autowired
    private HocSinhService hocSinhService;

//    @GetMapping("/list")
//    public String list(Model model){
//      List<phieudiem> phieudiemList =  phieuDiemService.getAllPhieuDiem();
//
//      model.addAttribute("phieudiemList", phieudiemList);
//
//      return ("phieudiem/phieudiem");
//    }

    @GetMapping("/list")
    public String list(Model model){
        List<monhoc> monhocList = monHocService.getAllMonHoc();
        model.addAttribute("monhocList", monhocList);
//        List<phieudiem> phieudiemList =  phieuDiemService.getAllPhieuDiem();
//
//        model.addAttribute("phieudiemList", phieudiemList);

        return ("phieudiem/phieudiem");
    }

    @GetMapping("/getdetail")
    public String listDetail(@RequestParam("id") int id,  Model model){
        monhoc monhoc = monHocService.getMonHocById(id);
        model.addAttribute("monhoc", monhoc);

        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        model.addAttribute("hocsinhList" ,hocsinhList);

//        model.addAttribute("monhocList", monhocList);
//        List<phieudiem> phieudiemList =  phieuDiemService.getAllPhieuDiem();
//
//        model.addAttribute("phieudiemList", phieudiemList);

        return ("phieudiem/phieudiem");
    }
}
