package br.com.helison.core.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.Issue;
import br.com.helison.core.services.IssueService;


@Path("/user")
public class UserResource {
    @Inject
    IssueService issueService;

    @GET
    @Path("/{id}/interactions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> userInteractions(@PathParam String id) {
        List<Issue> issues = new ArrayList<>();
        try {
            issues = issueService.getUserInteractions(id);
            System.out.println(issues);
            
        } catch (NullPointerException | SQLException ex) {
            System.out.println("Erro: " + ex.getMessage() + ex.getCause());
        }
        return issues;
    }
}