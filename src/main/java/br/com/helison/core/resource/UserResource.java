package br.com.helison.core.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.redmine.Issue;
import br.com.helison.core.models.redmine.User;

@Path("/user")
public class UserResource {

    @GET
    @Path("/{id}/interactions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> userInteractions(@PathParam String id) {
        List<Issue> issues = new ArrayList<>();

        try {
            issues = Issue.getUserInteractions(id);
        } catch (NullPointerException | SQLException ex) {
            System.out.println("Erro: " + ex.getMessage() + ex.getCause());
        }

        return issues;

    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        return User.listAll();
    }
}