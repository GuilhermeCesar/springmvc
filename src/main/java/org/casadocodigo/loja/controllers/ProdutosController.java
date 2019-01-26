package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDao produtoDao;

    @RequestMapping(value = "/produtos/form", method = RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public String grava(Produto produto){
        System.out.println(produto);
        this.produtoDao.gravar(produto);

        return "produtos/ok";
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        List<Produto> produtos = this.produtoDao.listar();

        modelAndView.addObject("produtos", produtos);

        return modelAndView;

    }
}
