package com.example.demo_qlhs_c3.controller;

import com.example.demo_qlhs_c3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_qlhs_c3.DTO.monhocDTO;
import com.example.demo_qlhs_c3.entity.monhoc;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class login {

    private UserRepository userRepository;

    @Autowired
    public login(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public void findMon(){
        List<monhoc> list = userRepository.findAll();
        List<monhocDTO> listDTO = new ArrayList<>();
        for (monhoc monHoc : list)
        {

            System.out.println(monHoc.getId());
            System.out.println(monHoc.getTenMonHoc());
        }
    }
}
