package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.daos.ProdutoDao;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.casadocodigo.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDao produtoDao;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("form")
    public ModelAndView form(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){

        System.out.println(sumario.getOriginalFilename());


        if(result.hasErrors()){
            return this.form(produto);
        }

        this.produtoDao.gravar(produto);

        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");

        System.out.println("Redirect produtos");

        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
        System.out.println("Chegou no produto");
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        List<Produto> produtos = this.produtoDao.listar();

        modelAndView.addObject("produtos", produtos);

        return modelAndView;

    }
}
