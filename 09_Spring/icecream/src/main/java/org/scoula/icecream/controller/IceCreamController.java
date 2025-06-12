package org.scoula.icecream.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/icecream")
@RequiredArgsConstructor
public class IceCreamController {

    final private IcecreamService service;

    @PostMapping("/new")
    public String create(IcecreamDTO icecream){
        log.info("create: "+icecream);
        service.create(icecream);
        return "redirect:/icecream/list";
    }

    @GetMapping("/list")
    public void get(Model model){
        log.info("list");
        model.addAttribute("icecreamList",service.getList());;
    }
}
