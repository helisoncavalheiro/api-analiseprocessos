
package br.com.helison.core.utils;

import br.com.helison.core.models.redmine.User;
import io.smallrye.jwt.build.Jwt;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

public class TokenUtil {

    public static String generateJwt(User user) {
        try {
            JsonArray rolesArray = Json.createArrayBuilder().add("User").add("Admin").build();
            
            JsonObject claims = Json.createObjectBuilder()
                    .add("upn", user.getLogin())
                    .add("full_name", user.getFirstname() + user.getLastname())
                    .add("login", user.getLogin())
                    .add("groups", rolesArray).build();

            String token = Jwt.claims(claims).sign();
            return token;

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}