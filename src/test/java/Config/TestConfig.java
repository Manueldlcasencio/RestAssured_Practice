package Config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.BeforeClass;

public class TestConfig {
    @BeforeClass
    public static void setup () {
        RestAssured.baseURI = "https://videogamedb.uk/";
        RestAssured.basePath = "api/v2/";
        RestAssured.port = 443;

        RestAssured.requestSpecification = new RequestSpecBuilder()
            //Modifies the request, in this case adding the header for application json.
                .setContentType("application/json")
                .addHeader("Accept", "application/json")
                .build(); //Apply the previous.

        RestAssured.responseSpecification = new ResponseSpecBuilder()
            //Modifies the expected response, in this case asking for status code 200.
                .expectStatusCode(200)
                .build();
    }
}
