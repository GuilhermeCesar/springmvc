package org.casadocodigo.loja.daos;

import org.casadocodigo.loja.models.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDao implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    public UserDetails loadUserByUsername(String email) {
        List<Usuario> usuarios = manager
                .createQuery("select u from Usuario u where u.email = :email", Usuario.class)
                .setParameter("email",email)
                .getResultList();

        if(usuarios.isEmpty()){
            throw new UsernameNotFoundException("Usuário "+email+" não encontrado");
        }

        return usuarios.get(0);
    }
}
