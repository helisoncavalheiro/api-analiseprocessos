package br.com.helison.core.resource;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.utils.RequestUtil;
import br.com.helison.core.utils.Constantes;

@Path("/issue")
public class IssueResource {
    
    @Inject
    private RequestUtil request;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIssue(@PathParam String id){
        String response;
        try{
            System.out.println();
            response = request.get(Constantes.URL_ISSUE + id 
            + Constantes.TYPE + Constantes.ACTIONS);
        }catch(IOException|InterruptedException ioE){
            response = "Não foi possível obter um resultado, erro: " 
            + ioE.getMessage();
        }
        return response;
    }

}