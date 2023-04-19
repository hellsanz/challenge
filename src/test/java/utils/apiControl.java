package utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class apiControl {
    private String uri = "https://petstore.swagger.io";


    public container petPost(String name, container container) {
        // Definir la especificación de la solicitud
        RequestSpecification requestSpec = given()
                .baseUri(uri)
                .basePath("/v2")
                .contentType("application/json")
                .body("{ \"name\": \""+name+"\" }");

        // Enviar la solicitud POST
        Response response = requestSpec.when()
                .post("/pet")
                .then()
                .extract()
                .response();
        //setting container info to return
        String responseBody = response.getBody().asString();
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
        String petName = json.get("name").getAsString();
        String petId = json.get("id").getAsString();
        container.setName(petName);
        container.setId(Long.parseLong(petId));
        container.setStatusCode(response.getStatusCode());
        return container;
    }
    public container petGet(long Id, container container) {
        // Definir la especificación de la solicitud
        RequestSpecification requestSpec = given()
                .baseUri(uri)
                .basePath("/v2")
                .contentType("application/json");

        // Enviar la solicitud GET
        Response response = requestSpec.when()
                .get("/pet/" + Id)
                .then()
                .extract()
                .response();

        // Obtener la información de la respuesta
        String responseBody = response.getBody().asString();
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
        String petName = json.get("name").getAsString();
        String petId = json.get("id").getAsString();

        // Configurar la información del contenedor para devolver
        container.setName(petName);
        container.setId(Long.parseLong(petId));
        container.setStatusCode(response.getStatusCode());

        return container;
    }

    public container petPut(Long id, container container) {
        // Definir la especificación de la solicitud
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("id", container.getId()); // Modificación
        jsonBody.addProperty("name", container.getName());

        RequestSpecification requestSpec = given()
                .baseUri(uri)
                .basePath("/v2")
                .contentType("application/json")
                .body(jsonBody.toString());

        // Enviar la solicitud PUT
        Response response = requestSpec.when()
                .put("/pet")
                .then()
                .extract()
                .response();

        // Validar la respuesta
        container.setStatusCode(response.getStatusCode());
        if (response.getStatusCode() == 200) { // Modificación
            JsonObject responseBody = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
            container.setId(responseBody.get("id").getAsLong());
            container.setName(responseBody.get("name").getAsString());
            container.setPhotoUrls(new ArrayList<String>());
            container.setTags(new ArrayList<String>());
        }
        return container;
    }
}
