package steps.asserts;

import io.restassured.response.Response;
import models.get.GettingAuthorsBooksRs;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetLibraryEndpoint {

    public static <T> void shouldBeEquals(T actual, T expected) {

        assertEquals(expected, actual);
    }

    public static void checkStatusCode(Response response, int statusCode) {

        response
                .then()
                .statusCode(statusCode);
    }

    public static void checkStatusCodeGetBooksJson(GettingAuthorsBooksRs responseModel, int statusCode) {

        assertEquals(statusCode, responseModel.getStatusCode());
    }
}
