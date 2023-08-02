import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import Objects.VideoGame;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class ObjectTests extends VideoGameConfig {

    @Test
    public void videoGameSerialization () {
        VideoGame game = new VideoGame("Shooter", "Goldeneye", "Mature", "27/09/1998", 89);

        given()
                .body(game)
        .when()
                .post(VideoGameEndpoints.All_Video_Games)
        .then();
    }

    @Test
    public void videoGameSchema () {
        given()
                .pathParam("Id", 5)
                .accept("application/json")
            .when()
                .get(VideoGameEndpoints.Single_Video_Game)
            .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }

    @Test
    public void convertJsonToObject () {
        Response response =
                given()
                        .pathParam("Id", 5)
                    .when()
                        .get(VideoGameEndpoints.Single_Video_Game);

        VideoGame newGame = response.getBody().as(VideoGame.class);
        //This test will fail because object VideoGame has no id variable.
        System.out.println(newGame);
    }
}
