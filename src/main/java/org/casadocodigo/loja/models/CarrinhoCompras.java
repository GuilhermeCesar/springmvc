package org.casadocodigo.loja.models;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem item){
        itens.put(item, this.getQuantidade(item) + 1);
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
                .reduce(0,(proximo, acumulador)->proximo+acumulador);

    }
}
