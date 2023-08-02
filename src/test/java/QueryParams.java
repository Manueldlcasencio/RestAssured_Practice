import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class QueryParams extends VideoGameConfig {
    @Test
    public void getDetailsWithParams() {
        given()
                .queryParam("name", "Mario")
                .get(VideoGameEndpoints.All_Video_Games);

    }
    @Test
    public void assertName () {
        given()
                .when()
                    .get(VideoGameEndpoints.All_Video_Games)
                .then()
                    .body("name[6]", equalTo("Minecraft"));
    }

    @Test
    public void getAllResponse () {
        String response = get(VideoGameEndpoints.All_Video_Games).asString();
        System.out.println(response);
    }
}
