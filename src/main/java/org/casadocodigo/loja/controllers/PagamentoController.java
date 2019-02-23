package org.casadocodigo.loja.controllers;

import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CarrinhoCompras carrinho;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes model){
        return () ->{
            String uri = "http://book-payment.herokuapp.com/payment";
            try{
                String response = restTemplate.postForObject(uri,new DadosPagamento(carrinho.getTotal()),String.class);
                System.out.println(response);
                model.addFlashAttribute("sucesso", response);
                return new ModelAndView("redirect:/produtos");
            }catch (HttpClientErrorException e){
                model.addFlashAttribute("falha", "Valor maior que o permitido");
                e.printStackTrace();
                return new ModelAndView("redirect:/produtos");
            }
        };
    }
}
