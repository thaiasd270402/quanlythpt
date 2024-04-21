package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.MonHocService;
import com.example.demo_qlhs_c3.service.SoHocBaService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.sohocba;
import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.entity.phieudiem;
import com.example.demo_qlhs_c3.entity.monhoc;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sohocba")
public class SoHocBaConTroller {
    @Autowired
    private SoHocBaService soHocBaService;
    @Autowired
    private HocSinhService hocSinhService;

    @Autowired
    private MonHocService monHocService;

    @PostConstruct
    public void insert_all_hocsinh() {

        List<sohocba> sohocbaList = soHocBaService.getAllSoHocBa();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        if (sohocbaList.isEmpty()) {
            for (hocsinh hocsinh1 : hocsinhList) {
                sohocba sohocba = new sohocba();
                sohocba.setHocSinh(hocsinh1);

                soHocBaService.saveSoHocBa(sohocba);
            }
        }


    }


    @GetMapping("/list")
    public String list(Model model) {

        //khi tạo 1 học sinh mới và quay trở lại sohocba thì 1 học sinh mới lập tức được lưu xuống sohocba
        List<sohocba> sohocbaList = soHocBaService.getAllSoHocBa();
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        for (hocsinh hocsinh1 : hocsinhList) {
            boolean flag = false;
            for (sohocba sohocba1 : sohocbaList) {
                if (hocsinh1.getId() == sohocba1.getHocSinh().getId()) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                sohocba sohocba = new sohocba();
                sohocba.setHocSinh(hocsinh1);
                soHocBaService.saveSoHocBa(sohocba);
            }

        }

        model.addAttribute("listHocSinh", hocsinhList);

        return ("sohocba/sohocba-list-by-hocsinh");
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model) {
        List<sohocba> sohocbaList = soHocBaService.getAllSoHocBa();
        sohocba sohocba = new sohocba();
        for (sohocba sohocba1 : sohocbaList) {
            if (sohocba1.getHocSinh().getId() == id) {
                sohocba = sohocba1;
                break;
            }
        }


        String tenLop = sohocba.getHocSinh().getLop().getTenLop();
        model.addAttribute("tenLop", tenLop);

        //tính điểm trung bình
        hocsinh hocsinh = hocSinhService.getHocSinhById(id);
        List<phieudiem> phieudiemList = hocsinh.getPhieuDiem();
        List<monhoc> monhocList = monHocService.getAllMonHoc();

        //mảng chuwaso tổng điểm các môn
        Float[] sumarr = new Float[monhocList.size()];
        Arrays.fill(sumarr, 0f);

        //mảng chứa số lượng bài kiểm tra các môn tương ứng
        Float[] lengtharr = new Float[monhocList.size()];
        Arrays.fill(lengtharr, 0f);
        for (int i = 0; i < monhocList.size(); i++) {
            for (int j = 0; j < phieudiemList.size(); j++) {
                if (monhocList.get(i).getTenMonHoc().equals(phieudiemList.get(j).getMonHoc().getTenMonHoc())) {
                    sumarr[i] += phieudiemList.get(j).getDiemSo();
                    lengtharr[i] += 1;
                    sumarr[i] += phieudiemList.get(j).getDiemSo();
                    lengtharr[i] += 1;
                }

            }
        }
        Float[] sumTotal = new Float[monhocList.size()];
        Arrays.fill(sumTotal, 0f);

        //tính điểm trung bình của từng môn sau đó đưa vào sumTotal
        for (int i = 0; i < sumarr.length; i++) {
            sumTotal[i] = sumarr[i] / lengtharr[i];
        }

        Float sumAll = 0f;
        for (int i = 0; i < sumTotal.length; i++) {

            sumAll += sumTotal[i];

        }


        //điểm tb cả năm  = tổng điểm trung bình của từng môn/số lượng môn học
        Float diemTb = sumAll / sumTotal.length;
        diemTb = (float) Math.round(diemTb * 100) / 100;
        sohocba.setDiemTrungBinh(diemTb);

        //xét học lực
        //Từ 9,0 đến 10,0: Xuất sắc;
        // Từ 8,0 đến cận 9,0: Giỏi;
        // Từ 7,0 đến cận 8,0: Khá;
        // Từ 5,0 đến cận 7,0: Trung bình;
        // Từ 4,0 đến cận 5,0: Yếu;
        // Dưới 4,0: Kém.
        if (diemTb >= 9.0) {
            sohocba.setHocLuc("Xuất sắc");
        } else if (diemTb >= 8.0 && diemTb < 9.0) {
            sohocba.setHocLuc("Giỏi");
        } else if (diemTb >= 7.0 && diemTb < 8.0) {
            sohocba.setHocLuc("Khá");
        } else if (diemTb >= 5.0 && diemTb < 7.0) {
            sohocba.setHocLuc("Trung bình");
        } else if (diemTb >= 4.0 && diemTb < 5.0) {
            sohocba.setHocLuc("Yếu");
        } else {
            sohocba.setHocLuc("Kém");
        }


        model.addAttribute("sohocba", sohocba);
        return ("sohocba/sohocba-detail");
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("sohocba") sohocba sohocba, Model model) {
        int id = sohocba.getId();
        soHocBaService.updateSoHocBa(sohocba, id);

        sohocba sohocba1 = soHocBaService.getSoHocBaById(sohocba.getId());
        System.out.println(sohocba1.getDiemTrungBinh());
        model.addAttribute("sohocba", sohocba1);

        return ("sohocba/sohocba-form-update");
    }

    @PostMapping("/save")
    private String save(@ModelAttribute("sohocba") sohocba sohocba) {
        int id = sohocba.getId();
        soHocBaService.updateSoHocBa(sohocba, id);
        return "redirect:/sohocba/detail?id=" + sohocba.getHocSinh().getId();
    }

    @GetMapping("/back")
    public String back() {
        return "redirect:/sohocba/list";
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

        model.addAttribute("listHocSinh", hocsinhList);

        return ("sohocba/sohocba-list-by-hocsinh");


    }

}
