package org.casadocodigo.loja.daos;

import org.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ProdutoDao {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto){
        manager.persist(produto);
    }

    public List<Produto> listar(){
        return manager.createQuery("select p from Produto p").getResultList();
    }

    public Produto find(Integer id) {
        StringBuilder hql = new StringBuilder();
        hql.append("select distinct (p) from Produto p join fetch p.precos preco ")
            .append("where p.id = :id");

        return this.manager.createQuery(hql.toString(),Produto.class)
                .setParameter("id",id)
                .getSingleResult();
    }
}
