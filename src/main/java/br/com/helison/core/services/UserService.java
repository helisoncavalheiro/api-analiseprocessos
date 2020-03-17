package br.com.helison.core.services;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.helison.core.models.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserService implements PanacheRepository<User>{


    public List<User> getAllUsers(){
        return listAll();
    }
}