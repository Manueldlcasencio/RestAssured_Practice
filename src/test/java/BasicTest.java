import Config.TestConfig;
import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class BasicTest extends VideoGameConfig {
    @Test
    public void basicTest() {
        given()
                .log().all() //Make logs to check everything so we can read it. Useful for debugging or learning.
        .when()
                .get("/videogame")
        .then()
                .log().all();
    }

    @Test
    public void TestWithEndpoints() {
        get(VideoGameEndpoints.All_Video_Games)
            //Use the variable of the interface to get the url
                .then().log().all();
    }
}
