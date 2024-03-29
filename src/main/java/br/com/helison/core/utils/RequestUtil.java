package br.com.helison.core.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RequestUtil {

    private HttpClient httpClient;
    private URI uri;
    private int statusCode;
    private String apiToken;
    private String tokenProperty;

    public RequestUtil() {
        this.httpClient = HttpClient.newHttpClient();
        this.tokenProperty = Constantes.PAREMETRO_API_TOKEN;
        this.apiToken = Constantes.TOKEN;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    private void setUri(String uri) {
        try {
            this.uri = new URI(uri);
        } catch (URISyntaxException e) {
            
        }
    }

    public String get(String uri) throws IOException, InterruptedException {
        setUri(uri);
        HttpResponse<String> response = this.httpClient.send(
                HttpRequest.newBuilder(this.uri).headers(this.tokenProperty, this.apiToken).GET().build(),
                BodyHandlers.ofString());
        this.statusCode = response.statusCode();
        return response.body();
    }

}