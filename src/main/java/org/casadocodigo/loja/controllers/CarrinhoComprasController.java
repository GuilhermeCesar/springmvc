package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.CarrinhoItem;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/carrinho")
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco){
        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem carrinhoItem = this.criaItem(produtoId, tipoPreco);

        this.carrinho.add(carrinhoItem);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView itens(){
        return new ModelAndView("carrinho/itens");
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco){
        Produto produto = this.produtoDao.find(produtoId);

        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);

        return carrinhoItem;

    }


    @RequestMapping("/remover")
    public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
        carrinho.remover(produtoId,tipoPreco);

        return new ModelAndView("redirect:/carrinho");
    }
}
