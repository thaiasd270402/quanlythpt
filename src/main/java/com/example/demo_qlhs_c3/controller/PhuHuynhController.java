package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.repository.PhuHuynhRepository;
import com.example.demo_qlhs_c3.service.HocSinhService;
import com.example.demo_qlhs_c3.service.LopHocService;
import com.example.demo_qlhs_c3.service.PhuHuynhService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo_qlhs_c3.entity.phuhuynh;
import com.example.demo_qlhs_c3.entity.hocsinh;
import com.example.demo_qlhs_c3.entity.lop;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phuhuynh")
public class PhuHuynhController {

    @Autowired
    private PhuHuynhService phuHuynhService;

    @Autowired
    private HocSinhService hocSinhService;


    @Autowired
    private LopHocService lopHocService;

    @PostConstruct
    public void createPhuHuynhFromHocSinh() {
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        List<phuhuynh> phuhuynhList = phuHuynhService.getAllPhuHuynh();


        if (phuhuynhList.isEmpty()) {
            for (hocsinh hocsinh1 : hocsinhList) {


                phuhuynh phuhuynh1 = new phuhuynh();

                phuhuynh1.setIdHocSinh(hocsinh1.getId());
                phuhuynh1.setHocSinh(hocsinh1);

                System.out.println(phuhuynh1);
                phuHuynhService.savePhuHuynh(phuhuynh1);
            }
        }

    }

    @GetMapping("/list")
    public String listByLop(Model model) {
        List<hocsinh> hocsinhList = hocSinhService.getAllHocSinh();
        List<phuhuynh> phuhuynhList = phuHuynhService.getAllPhuHuynh();

        for (hocsinh hocsinh1 : hocsinhList) {
            boolean check = false;
            for (phuhuynh phuhuynh1 : phuhuynhList) {
                if (hocsinh1.getId() == phuhuynh1.getIdHocSinh()) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                phuhuynh phuhuynh1 = new phuhuynh();

                phuhuynh1.setIdHocSinh(hocsinh1.getId());
                phuhuynh1.setHocSinh(hocsinh1);

                System.out.println(phuhuynh1);
                phuHuynhService.savePhuHuynh(phuhuynh1);
            }
        }

        List<lop> lopList = lopHocService.getAllLopHoc();
        model.addAttribute("lopList", lopList);
        return ("phuhuynh/phuhuynh-list-by-lophoc");
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int idLop, Model model) {
        List<phuhuynh> phuhuynhList = phuHuynhService.getAllPhuHuynh();
        List<phuhuynh> phuhuynhs = new ArrayList<>();
        for (phuhuynh phuhuynh1 : phuhuynhList) {
            if (phuhuynh1.getHocSinh().getLop().getId() == idLop) {
                phuhuynhs.add(phuhuynh1);
            }
        }

        lop lop1 = lopHocService.getLopHocById(idLop);
        model.addAttribute("tenLop", lop1.getTenLop());
        model.addAttribute("idLop", lop1.getId());
        model.addAttribute("phuhuynhs", phuhuynhs);

        return ("phuhuynh/phuhuynh-detail");
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        phuhuynh phuhuynh1 = phuHuynhService.getPhuHuynhById(id);

        model.addAttribute("phuhuynh", phuhuynh1);

        return ("phuhuynh/phuhuynh-form-update");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("phuhuynh") phuhuynh phuhuynh) {
        phuHuynhService.savePhuHuynh(phuhuynh);
        return "redirect:/phuhuynh/detail?id=" + phuhuynh.getHocSinh().getLop().getId();
    }

    @GetMapping("/search-lop")
    public String searchLop(@RequestParam("keyword1") String tenLop, Model model) {
        List<lop> lopList = lopHocService.getAllLopHoc();
        if (tenLop != null || !tenLop.isEmpty()) {
            lopList = lopHocService.serchByTenLop(tenLop);
        }
        model.addAttribute("tenLop", tenLop);
        model.addAttribute("lopList", lopList);
        return ("phuhuynh/phuhuynh-list-by-lophoc");
    }

    @GetMapping("search-inform")
    public String search_Inform(@RequestParam("keyword1") String tenHs, @RequestParam("keyword2") String tenPhuHuynh, @RequestParam("idLop") int idLop, Model model){
        List<phuhuynh> phuhuynhList = phuHuynhService.getAllPhuHuynh();
        List<phuhuynh> phuhuynhs = new ArrayList<>();
        for (phuhuynh phuhuynh1 : phuhuynhList){
            if(phuhuynh1.getHocSinh().getLop().getId()==idLop){
                phuhuynhs.add(phuhuynh1);
            }
        }

        if(tenHs == null || tenHs.isEmpty()){
            List<phuhuynh> phuhuynhList1 = phuHuynhService.searchByPh(tenPhuHuynh);
            List<phuhuynh> phuhuynhs1 = new ArrayList<>();
            for (phuhuynh phuhuynh1 : phuhuynhList1){
                if(phuhuynh1.getHocSinh().getLop().getId()==idLop){
                    phuhuynhs1.add(phuhuynh1);
                }
            }

            phuhuynhs = phuhuynhs1;
        }else if (tenPhuHuynh == null || tenPhuHuynh.isEmpty()){
            List<phuhuynh> phuhuynhList1 = phuHuynhService.searchByHs(tenHs);
            List<phuhuynh> phuhuynhs1 = new ArrayList<>();
            for (phuhuynh phuhuynh1 : phuhuynhList1){
                if(phuhuynh1.getHocSinh().getLop().getId()==idLop){
                    phuhuynhs1.add(phuhuynh1);
                }
            }
            phuhuynhs = phuhuynhs1;
        } else {
            List<phuhuynh> phuhuynhList1 = phuHuynhService.searchByPhAndHs(tenHs, tenPhuHuynh);
            List<phuhuynh> phuhuynhs1 = new ArrayList<>();
            for (phuhuynh phuhuynh1 : phuhuynhList1){
                if(phuhuynh1.getHocSinh().getLop().getId()==idLop){
                    phuhuynhs1.add(phuhuynh1);
                }
            }
            phuhuynhs = phuhuynhs1;
        }

        lop lop1 = lopHocService.getLopHocById(idLop);
        model.addAttribute("tenLop", lop1.getTenLop());
        model.addAttribute("idLop", lop1.getId());
        model.addAttribute("tenHocSinh", tenHs);
        model.addAttribute("tenPhuHuynh",tenPhuHuynh);
        model.addAttribute("phuhuynhs", phuhuynhs);

        return ("phuhuynh/phuhuynh-detail");
    }
}
