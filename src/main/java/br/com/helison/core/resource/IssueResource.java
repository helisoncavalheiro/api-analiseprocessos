package br.com.helison.core.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.redmine.Issue;

@Path("/issue")
@RolesAllowed("Admin")
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

    @GET
    @Path("/project/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getIssuesByProject(@PathParam String projectId){

        List<Issue> openIssuesOnProject = Issue.getOpenIssuesByProject(Long.parseLong(projectId));
        return openIssuesOnProject;
    }
}