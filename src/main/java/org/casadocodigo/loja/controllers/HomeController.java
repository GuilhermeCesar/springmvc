package org.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class
HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        System.out.println("Entrando na home da casa do código");

        return "home";
    }
}