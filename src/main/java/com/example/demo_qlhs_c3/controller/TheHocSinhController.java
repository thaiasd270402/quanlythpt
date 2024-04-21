package com.example.demo_qlhs_c3.controller;
import com.example.demo_qlhs_c3.entity.thehocsinh;
import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.TheHocSinhService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo_qlhs_c3.entity.hocsinh;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/thehocsinh")
public class TheHocSinhController {
    @Autowired
    private TheHocSinhService theHocSinhService;

    @Autowired
    private HocSinhService hocSinhService;

    @PostConstruct
    public void addAllHocSinhForTheHs(){
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        List<thehocsinh> thehocsinhList = theHocSinhService.getAllTheHocSinh();
        if(thehocsinhList.isEmpty()){
            for (hocsinh hocsinh1 : hocsinhList){
                thehocsinh thehocsinh1 = new thehocsinh();
                thehocsinh1.setHocSinh(hocsinh1);

                theHocSinhService.saveTheHocSinh(thehocsinh1);
            }
        }
    }

    @GetMapping("/list")
    public String list(Model model){
        List<thehocsinh> thehocsinhList = theHocSinhService.getAllTheHocSinh();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();

        //khi thêm mới 1 học sinh thì tụ đọng thêm vào thehocsinh
        for (hocsinh hocsinh1 : hocsinhList){
            boolean check = false;
            for (thehocsinh thehocsinh1 : thehocsinhList){
                if(hocsinh1.getId()==thehocsinh1.getHocSinh().getId()){
                    check = true;
                    break;
                }
            }

            if(!check){
                thehocsinh thehocsinh2 = new thehocsinh();
                thehocsinh2.setHocSinh(hocsinh1);
                theHocSinhService.saveTheHocSinh(thehocsinh2);
            }
        }

        List<thehocsinh> thehocsinhs = theHocSinhService.getAllTheHocSinh();

        model.addAttribute("thehocsinhs", thehocsinhs);

        return ("thehocsinh/thehocsinh-list");
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model){
        thehocsinh thehocsinh = theHocSinhService.getTheHocSinhById(id);
        model.addAttribute("thehocsinh", thehocsinh);
        return ("thehocsinh/thehocsinh-form");
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("thehocsinh") thehocsinh thehocsinh, @RequestParam("fileName") MultipartFile  file){
        String fileName = file.getOriginalFilename();
        thehocsinh.setAnhDaiDien(fileName);
        theHocSinhService.saveTheHocSinh(thehocsinh);
        return "redirect:/thehocsinh/list";

    }

    @GetMapping("/search-in-form")
    public String searchInForm(@RequestParam("keyword1") String tenHocSinh,
                               @RequestParam("keyword2") String tenLop, Model model) {
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        if (tenHocSinh == null || tenHocSinh.isEmpty()) {
            hocsinhList = hocSinhService.searchLop(tenLop);
        } else if (tenLop == null || tenLop.isEmpty()) {
            hocsinhList = hocSinhService.searchName(tenHocSinh);
        } else {
            hocsinhList = hocSinhService.searchNameAndClass(tenHocSinh, tenLop);
        }

        model.addAttribute("tenHocSinh", tenHocSinh);
        model.addAttribute("tenLop", tenLop);

        List<thehocsinh> thehocsinhList = theHocSinhService.getAllTheHocSinh();
        List<thehocsinh> thehocsinhs = new ArrayList<>();
        for (hocsinh hocsinh1 : hocsinhList){
            for (thehocsinh thehocsinh1 : thehocsinhList){
                if(hocsinh1.getId()==thehocsinh1.getHocSinh().getId()){
                    thehocsinhs.add(thehocsinh1);
                    break;
                }
            }
        }

        model.addAttribute("thehocsinhs", thehocsinhs);
        return ("thehocsinh/thehocsinh-list");


    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/thehocsinh/list";
    }
}
