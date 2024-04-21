package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.entity.*;
import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.LopHocService;
import com.example.demo_qlhs_c3.service.MonHocService;
import com.example.demo_qlhs_c3.service.PhieuDIemService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private LopHocService lopHocService;

    @PostConstruct
    public void insert_all_hocsinh() {

        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        List<monhoc> monhocList = monHocService.getAllMonHoc();
        if (phieudiemList.isEmpty()) {
            for (hocsinh hocsinh1 : hocsinhList) {
                for (monhoc monhoc : monhocList) {
                    phieudiem phieudiem1 = new phieudiem();
                    phieudiem1.setLop(hocsinh1.getLop());
                    phieudiem1.setHocSinh(hocsinh1);
                    phieudiem1.setMonHoc(monhoc);
                    phieuDiemService.savePhieuDiem(phieudiem1);
                }
            }
        }


    }

    @GetMapping("/list")
    public String list(Model model) {
        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
        model.addAttribute("phieudiemList", phieudiemList);

        return ("phieudiem/phieudiem-list");
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        phieudiem phieudiem = phieuDiemService.getPhieuDiemById(id);

        model.addAttribute("phieudiem", phieudiem);

        return ("phieudiem/phieudiem-form");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("phieudiem") phieudiem phieudiem) {

        int id = phieudiem.getId();
        phieuDiemService.updatePhieuDiem(phieudiem, id);

        return "redirect:/phieudiem/list";
    }

    @GetMapping("/creatphieudiem")
    public String creatphieudiem(@RequestParam("id") int id, Model model) {
        phieudiem phieudiem = phieuDiemService.getPhieuDiemById(id);
        phieudiem phieudiem1 = new phieudiem();
        phieudiem.setDiemSo(phieudiem1.getDiemSo());
        phieudiem.setNgayKiemTra(phieudiem1.getNgayKiemTra());
        phieudiem.setHocKy(phieudiem1.getHocKy());
        model.addAttribute("phieudiem", phieudiem);

        return ("phieudiem/phieudiem-form-save");
    }

    @GetMapping("/creatphieudiem-inform")
    public String creatphieudieminform(@RequestParam("id") int id, Model model) {
        phieudiem phieudiem = phieuDiemService.getPhieuDiemById(id);
        phieudiem phieudiem1 = new phieudiem();
        phieudiem.setDiemSo(phieudiem1.getDiemSo());
        phieudiem.setNgayKiemTra(phieudiem1.getNgayKiemTra());
        phieudiem.setHocKy(phieudiem1.getHocKy());
        model.addAttribute("phieudiem", phieudiem);

        return ("phieudiem/phieudiem-form-save-view");
    }

    @PostMapping("/savephieudiem")
    public String savephieudiem(@ModelAttribute("phieudiem") phieudiem phieudiem) {

        phieuDiemService.savePhieuDiem(phieudiem);

        return "redirect:/phieudiem/list";
    }

    @PostMapping("/savephieudiem-inform")
    public String savephieudieminform(@ModelAttribute("phieudiem") phieudiem phieudiem) {

        phieuDiemService.savePhieuDiem(phieudiem);

        return "redirect:/phieudiem/getdetail?id=" + phieudiem.getMonHoc().getId();
    }


    @GetMapping("/getdetail")
    public String detail(@RequestParam("id") int id, Model model) {
        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
        List<phieudiem> phieudiems = new ArrayList<>();


        for (phieudiem phieudiem : phieudiemList) {
            if (phieudiem.getMonHoc().getId() == id) {
                phieudiems.add(phieudiem);
            }
        }

        phieudiem phieudiem = phieudiems.get(0);
        model.addAttribute("phieuDiem", phieudiem);

        model.addAttribute("phieudiemList", phieudiems);

        return ("phieudiem/phieudiem-view-monhoc-list");
    }

    @GetMapping("/list-by-monhoc")
    public String listByMonHoc(Model model) {
        List<monhoc> monhocList = monHocService.getAllMonHoc();
        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        for (hocsinh hocsinh : hocsinhList) {
            int i = 0;
            for (phieudiem phieudiem : phieudiemList) {
                i++;
                if (hocsinh.getId() == phieudiem.getHocSinh().getId()) {
                    break;
                }
                if (i == phieudiemList.size()) {
                    for (monhoc monhoc : monhocList) {
                        phieudiem phieudiem1 = new phieudiem();
                        phieudiem1.setLop(hocsinh.getLop());
                        phieudiem1.setHocSinh(hocsinh);
                        phieudiem1.setMonHoc(monhoc);
                        phieuDiemService.savePhieuDiem(phieudiem1);
                    }
                }


            }


        }
        model.addAttribute("monhocList", monhocList);
        return ("phieudiem/phieudiem-view-monhoc");
    }

    @GetMapping("/update-view-form")
    public String updateViewForm(@RequestParam("id") int id, Model model) {
        phieudiem phieudiem = phieuDiemService.getPhieuDiemById(id);

        model.addAttribute("phieudiem", phieudiem);

        return ("phieudiem/phieudiem-view-form");
    }

    @PostMapping("/save-view-form")
    public String saveViewForm(@ModelAttribute("phieudiem") phieudiem phieudiem) {
        int id = phieudiem.getId();
        phieuDiemService.updatePhieuDiem(phieudiem, id);

        return "redirect:/phieudiem/getdetail?id=" + phieudiem.getMonHoc().getId();
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword1") String tenHocSinh,
                         @RequestParam("keyword2") String tenLop,
                         @RequestParam("keyword3") String tenMonHoc,
                         Model model) {
        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
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

        return ("phieudiem/phieudiem-list");
    }

    @GetMapping("/search-in-form")
    public String searchInForm(@RequestParam("keyword1") String tenHocSinh,
                               @RequestParam("keyword2") String tenLop,
                               @RequestParam("tenMonHoc") String tenMonHoc, Model model) {

        List<phieudiem> phieudiemList = phieuDiemService.getAllPhieuDiem();
        List<phieudiem> phieudiems = new ArrayList<>();
        for(phieudiem phieudiem1 : phieudiemList){
            if(phieudiem1.getMonHoc().getTenMonHoc().equals(tenMonHoc)){
                phieudiems.add(phieudiem1);
            }
        }

        if(tenHocSinh == null || tenHocSinh.isEmpty()){
            phieudiems = phieuDiemService.serchPhieuDiemByTenLopAndMonHoc(tenLop, tenMonHoc);
        }else if(tenLop == null || tenLop.isEmpty()){
            phieudiems = phieuDiemService.serchPhieuDiemByTenHocSinhAndMonHoc(tenHocSinh, tenMonHoc);
        }else {
            phieudiems =
                    phieuDiemService.serchPhieuDiemByTenHocSinh_Lop_MonHoc(tenHocSinh, tenLop, tenMonHoc);
        }


        model.addAttribute("tenHocSinh", tenHocSinh);
        model.addAttribute("tenLop", tenLop);
        monhoc monhoc = new monhoc();
        monhoc.setTenMonHoc(tenMonHoc);
        phieudiem phieudiem = new phieudiem();
        phieudiem.setMonHoc(monhoc);
//        phieudiem phieudiem = phieudiems.get(0);
        model.addAttribute("phieuDiem", phieudiem);

        model.addAttribute("phieudiemList", phieudiems);

        return ("phieudiem/phieudiem-view-monhoc-list");
    }


}
