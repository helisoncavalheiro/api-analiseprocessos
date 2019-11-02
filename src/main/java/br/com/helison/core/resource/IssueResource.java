package br.com.helison.core.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/issue")
public class IssueResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIssue(@PathParam String id) throws URISyntaxException, InterruptedException, IOException{
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(
            HttpRequest.newBuilder(new URI("https://demandas.urcamp.edu.br/issues.json?issue_id=" + id))
            .headers("X-Redmine-API-Key", "2a6ef493169d87a7ef7a2cffd08d7e15657f88f9")
            .GET()
            .build(), BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        String issue = response.body();
        return issue;
    }

}