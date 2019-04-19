package org.casadocodigo.loja.daos;

import org.casadocodigo.loja.builders.ProdutoBuilder;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDaoTest {

    @Test
    public void deveSomarTodosOsPrecosPorTipoDeLivro() {
        ProdutoDao produtoDao = new ProdutoDao();

        List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN)
                .more(3).buildAll();

        List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN)
                .more(3).buildAll();

        livrosImpressos.stream().forEach(ProdutoDao::gravar);
        livrosEbook.stream().forEach(ProdutoDao::gravar);

        BigDecimal valor = produtoDao.somaPrecoPorTipoPreco(TipoPreco.EBOOK);
        Assert.assertEquals(new BigDecimal("40").setScale(2),valor);
    }
}
