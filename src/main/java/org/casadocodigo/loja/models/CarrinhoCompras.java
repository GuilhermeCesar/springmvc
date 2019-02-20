package org.casadocodigo.loja.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem item){
        itens.put(item, this.getQuantidade(item) + 1);
    }


    public Collection<CarrinhoItem> getItens() {
        return itens.keySet();
    }

    private Integer getQuantidade(CarrinhoItem item) {
        if(!this.itens.containsKey(item)){
            itens.put(item,0);
        }
        return itens.get(item);
    }

    public int getQuantidade(){
        return itens.values()
                .stream()
                .reduce(0,(proximo, acumulador) -> proximo + acumulador );

    }

    public BigDecimal getTotal(CarrinhoItem item){
        return item.getTotal(this.getQuantidade(item));
    }
}
