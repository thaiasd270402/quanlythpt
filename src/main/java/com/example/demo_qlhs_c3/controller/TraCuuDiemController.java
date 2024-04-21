package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.entity.phieudiem;
import com.example.demo_qlhs_c3.service.PhieuDIemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tracuudiem")
public class TraCuuDiemController {
    @Autowired
    private PhieuDIemService phieuDiemService;

    @GetMapping("/list")
    public String list(){
        return ("tracuudiem/tracuudiem-form");
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword1") String tenHocSinh,
                         @RequestParam("keyword2") String tenLop,
                         @RequestParam("keyword3") String tenMonHoc,
                         Model model) {
        List<phieudiem> phieudiemList = new ArrayList<>();
        if ((tenHocSinh == null || tenHocSinh.isEmpty()) && (tenLop == null || tenLop.isEmpty()) && (tenMonHoc == null || tenMonHoc.isEmpty())) {
            phieudiemList = new ArrayList<>();
        } else
        if ((tenHocSinh == null || tenHocSinh.isEmpty()) && (tenLop == null || tenLop.isEmpty())) {
            phieudiemList = phieuDiemService.serchPhieuDiemByMonHoc(tenMonHoc);
        } else if((tenHocSinh == null || tenHocSinh.isEmpty()) && (tenMonHoc == null || tenMonHoc.isEmpty())){
            phieudiemList = phieuDiemService.serchPhieuDiemByLop(tenLop);
        }else if((tenLop == null || tenLop.isEmpty()) && (tenMonHoc == null || tenMonHoc.isEmpty())){
            phieudiemList = phieuDiemService.serchPhieuDiemByTenHocSinh(tenHocSinh);
        }else if(tenHocSinh == null || tenHocSinh.isEmpty()){
            phieudiemList = phieuDiemService.serchPhieuDiemByTenLopAndMonHoc(tenLop, tenMonHoc);
        }else if(tenLop == null || tenLop.isEmpty()){
            phieudiemList = phieuDiemService.serchPhieuDiemByTenHocSinhAndMonHoc(tenHocSinh, tenMonHoc);
        }else if(tenMonHoc == null || tenMonHoc.isEmpty()){
            phieudiemList = phieuDiemService.serchPhieuDiemByTenHocSinhAndLop( tenHocSinh, tenLop);
        }else{
            phieudiemList =
                    phieuDiemService.serchPhieuDiemByTenHocSinh_Lop_MonHoc(tenHocSinh, tenLop, tenMonHoc);
        }

        model.addAttribute("tenHocSinh", tenHocSinh);
        model.addAttribute("tenLop", tenLop);
        model.addAttribute("tenMonHoc", tenMonHoc);
        model.addAttribute("phieudiemList", phieudiemList);

        return ("tracuudiem/tracuudiem-form");
    }
}
