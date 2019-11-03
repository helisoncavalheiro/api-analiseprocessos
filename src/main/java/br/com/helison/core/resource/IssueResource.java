package br.com.helison.core.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.utils.RequestUtil;

@Path("/issue")
public class IssueResource {

    private RequestUtil request;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIssue(@PathParam String id){
        request = new RequestUtil("2a6ef493169d87a7ef7a2cffd08d7e15657f88f9" ,"X-Redmine-API-Key");
        String response;
        try{
            response = request.get("https://demandas.urcamp.edu.br/issues.json?issue_id=" + id);
        }catch(IOException ioE){
            response = "Não foi possível obter um resultado";
        }catch(InterruptedException e){
            response = "Não foi possível obter um resultado";
        }
        return response;
    }

}