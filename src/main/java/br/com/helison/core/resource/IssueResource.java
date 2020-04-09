package br.com.helison.core.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.Issue;
import br.com.helison.core.services.IssueService;

@Path("/issue")
public class IssueResource {

    @Inject
    private IssueService issueService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Issue getIssue(@PathParam String id){
        Issue issue = issueService.getIssue(Long.parseLong(id));
        return issue;
    }

    @GET
    @Path("/author/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getIssuesByAuthor(@PathParam String user){
        return Issue.getIssuesByAuthor(user);
    }
}