package br.com.helison.core.resource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.helison.core.models.redmine.User;
import br.com.helison.core.utils.TokenUtil;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;

@Path("/login")
public class LoginResource {

    @Inject
    JWTParser parser;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(JsonObject data) throws ParseException {
        System.out.println(data);
        User user = User.find("login", data.getString("user")).firstResult();

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        String hashedPasswordProvided = hashPassword(user.getSalt() + hashPassword(data.getString("password")));

        if (hashedPasswordProvided.equals(user.getHashedPassword()) && user.getAdmin()) {

            try {

                String token = TokenUtil.generateJwt(user);
                JsonObject body = Json.createObjectBuilder().add("token", token).build();

                return Response.status(Response.Status.ACCEPTED).entity(body).build();

            } catch (NullPointerException ex) {
                ex.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }

        }

        return Response.status(Response.Status.UNAUTHORIZED).build();

    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(password.getBytes());
            BigInteger bi = new BigInteger(1, hash);
            return String.format("%0" + (hash.length << 1) + "x", bi);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
