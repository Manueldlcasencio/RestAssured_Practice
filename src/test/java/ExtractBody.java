import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ExtractBody extends VideoGameConfig {

    @Test
    public void getAllData_CheckFirst () {
        Response response =
                given()
                        .when()
                            .get(VideoGameEndpoints.All_Video_Games)

                        .then()
                        .contentType(ContentType.JSON) //Check type of content
                        .extract().response(); //Save in the variable

        String responseString = response.asString();
        String contentTypeHeader = response.getHeader("Transfer-Encoding").toString();

        System.out.println(contentTypeHeader);
    }

    @Test
    public void extractFirstGame () {
        String firstGame = get(VideoGameEndpoints.All_Video_Games).jsonPath().getString("name[0]");
        //"name[0]" refers to the JSON path. So in case of complex objects could be game.name[0] or similar.
        System.out.println(firstGame);

        List<String> gameNames = get(VideoGameEndpoints.All_Video_Games).path("name");
        //This extract ALL names.
        System.out.println(gameNames);
    }
}
