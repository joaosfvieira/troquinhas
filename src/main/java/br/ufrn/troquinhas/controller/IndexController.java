package br.ufrn.troquinhas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {

    public String showIndex(){
        return "index";
    }
}
