package br.com.helison.core.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.helison.core.models.competo.Servico;

@Path("/servico")
public class ServicoResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Servico> getAllServicos() {
        return Servico.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Servico getServicoById(@PathParam Integer id) {
        return Servico.findById(id);
    }
}