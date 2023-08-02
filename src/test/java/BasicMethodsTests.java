import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BasicMethodsTests extends VideoGameConfig {
    @Test
    public void createNewGameJson() {
        String gameBodyJson = "{\n" +
                "  \"category\": \"Platform\",\n" +
                "  \"name\": \"Mario\",\n" +
                "  \"rating\": \"Mature\",\n" +
                "  \"releaseDate\": \"2022-05-04\",\n" +
                "  \"reviewScore\": 89\n" +
                "}";

        given()
                .body(gameBodyJson)
        .when()
                .post(VideoGameEndpoints.All_Video_Games)
        .then();
    }

    @Test
    public void putRequest() {
        String gameBodyJson = "{\n" +
                "  \"category\": \"Platform\",\n" +
                "  \"name\": \"Mario\",\n" +
                "  \"rating\": \"Mature\",\n" +
                "  \"releaseDate\": \"2022-05-04\",\n" +
                "  \"reviewScore\": 89\n" +
                "}";

        given()
                .body(gameBodyJson)
                .pathParam("Id", 3)
            .when()
                .put(VideoGameEndpoints.Single_Video_Game)
            .then();
    }
}

