package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class
HomeController {

    @Autowired
    private ProdutoDao produtoDao;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @Cacheable(value = "produtosHome")
    public ModelAndView index(){
        List<Produto> produtos = this.produtoDao.listar();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos",produtos);
        return modelAndView;
    }
}
