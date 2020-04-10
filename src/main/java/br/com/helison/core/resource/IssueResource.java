package br.com.helison.core.resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.Issue;

@Path("/issue")
public class IssueResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Issue getIssue(@PathParam String id){
        return Issue.findById(Long.parseLong(id));
    }

    @GET
    @Path("/author/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getIssuesByAuthor(@PathParam String user){
        return Issue.getIssuesByAuthor(user);
    }
}