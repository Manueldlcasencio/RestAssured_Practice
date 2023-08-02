import Config.VideoGameConfig;
import Config.VideoGameEndpoints;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPath extends VideoGameConfig {

    @Test
    public void extractMapOfElements () {
        Response response =
                get(VideoGameEndpoints.All_Video_Games);

        Map<String, ?> mapOfStuff = response.path("find( { it.name == 'Doom' })");

        System.out.println(mapOfStuff);
    }

    @Test
    public void findAllNames () {
        Response response =
                get(VideoGameEndpoints.All_Video_Games);

        List<String> gameNames = response.path("findAll { it.name != 'Doom' }.name");

        System.out.println(gameNames);
    }


}
