package steps.asserts;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class PostLibraryEndpoint {

    public static <T> void shouldBeEquals(T actual, T expected) {

        Assertions.assertEquals(expected, actual);
    }

    public static void checkStatusCode(Response response, int statusCode) {

        response
                .then()
                .statusCode(statusCode);
    }
}
