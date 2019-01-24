package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDao produtoDao;

    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }

    @RequestMapping(value = "/produtos")
    public String grava(Produto produto){
        System.out.println(produto);
        this.produtoDao.gravar(produto);

        return "produtos/ok";
    }
}
