package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.models.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes moodel){
        System.out.println(carrinho.getTotal());
        moodel.addFlashAttribute("sucesso", "Pagamento realizado com sucesso");

        return new ModelAndView("redirect:/produtos");
    }
}
