package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }

    @RequestMapping(value = "/produtos")
    public String grava(Produto produto){
        System.out.println(produto);

        return "produtos/ok";
    }
}
