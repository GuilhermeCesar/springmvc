package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.CarrinhoItem;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/carrinho")
@Controller
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco){
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = this.criaItem(produtoId, tipoPreco);




        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco){
        Produto produto = this.produtoDao.find(produtoId);

        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);

        return carrinhoItem;

    }
}