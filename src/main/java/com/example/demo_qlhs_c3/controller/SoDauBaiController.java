package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.GiaoVienService;
import com.example.demo_qlhs_c3.service.LopHocService;
import com.example.demo_qlhs_c3.service.SoDauBaiService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.lop;
import com.example.demo_qlhs_c3.entity.sodaubai;
import com.example.demo_qlhs_c3.entity.giaovien;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sodaubai")
public class SoDauBaiController {

    @Autowired
    private SoDauBaiService soDauBaiService;

    @Autowired
    private LopHocService lopHocService;

    @Autowired
    private GiaoVienService giaoVienService;

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
                sodaubai.setGiaoVien(lop1.getGiaoVien());
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

        model.addAttribute("idLop",idLop );

        model.addAttribute("sodaubais", sodaubais);
        return ("sodaubai/sodaubai-detail");


    }

    @GetMapping("/save")
    public String save( @RequestParam("id") int idLop,  Model model) {
        sodaubai sodaubai = new sodaubai();
        sodaubai.setLop(lopHocService.getLopHocById(idLop));
        List<giaovien> giaovienList = giaoVienService.getAllGiaoVien();
        model.addAttribute("giaovienList", giaovienList);
        model.addAttribute("sodaubai", sodaubai);
     return ("sodaubai/sodaubai-form-save");
    }

    @PostMapping("save-and-update")
    public String saveAndUpdate(@ModelAttribute("sodaubai") sodaubai sodaubai){
        soDauBaiService.saveSoDauBai(sodaubai);
        return "redirect:/sodaubai/detail?id=" + sodaubai.getLop().getId();
    }

    @GetMapping("/update")
    public String update( @RequestParam("id") int idSdb,  Model model) {
        sodaubai sodaubai = soDauBaiService.getSoDauBaiById(idSdb);
        List<giaovien> giaovienList = giaoVienService.getAllGiaoVien();
        model.addAttribute("giaovienList", giaovienList);
        model.addAttribute("sodaubai", sodaubai);
        return ("sodaubai/sodaubai-form-save");
    }

    @GetMapping("/delete")
    public String delete( @RequestParam("id") int idSdb) {
        sodaubai sodaubai1 = soDauBaiService.getSoDauBaiById(idSdb);
        soDauBaiService.deleteSoDauBaiById(idSdb);

        return "redirect:/sodaubai/detail?id=" + sodaubai1.getLop().getId();
    }

    @GetMapping("/search-lop")
    public String searchLop(@RequestParam("keyword1") String tenLop, Model model){
        List<lop> lopList = lopHocService.getAllLopHoc();
        if(tenLop!=null || !tenLop.isEmpty()){
            lopList=lopHocService.serchByTenLop(tenLop);
        }
        model.addAttribute("tenLop", tenLop);
        model.addAttribute("lopList", lopList);
        return ("sodaubai/sodaubai-list-by-lophoc");
    }

    @GetMapping("/back")
    public String back(Model model){
        List<lop> lopList = lopHocService.getAllLopHoc();
        model.addAttribute("lopList", lopList);
        return ("sodaubai/sodaubai-list-by-lophoc");
    }

    @GetMapping("/search-sdb")
    public String searcSdb(@RequestParam("keyword") Date ngay, @RequestParam("idLop") int idLop,  Model model){
//        List<sodaubai> sodaubaiList = soDauBaiService.searchSbdByDate(ngay);
        List<sodaubai> sodaubaiList = soDauBaiService.getAllSoDauBai();
        List<sodaubai> sodaubais =new ArrayList<>();

            // Xử lý khi có giá trị date

            for(sodaubai sodaubai1 : sodaubaiList){
                if(sodaubai1.getNgayGiangDay() != null){
                    if(sodaubai1.getNgayGiangDay().equals(ngay) && sodaubai1.getLop().getId()==idLop){
                        sodaubais.add(sodaubai1);
                    }
                }

            }


        System.out.println(sodaubais.size());
        model.addAttribute("ngayGiangDay", ngay);

//        model.addAttribute("idLop",idLop );
        model.addAttribute("idLop", idLop);
        model.addAttribute("sodaubais", sodaubais);
        return ("sodaubai/sodaubai-detail");
    }

}
