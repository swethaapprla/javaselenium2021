
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetCallTest {
    @Test
    public void getStatusCode() {
        given()
                .baseUri("http://dummy.restapiexample.com/api/v1/employee")
                .when()
                .get("/1")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("data.id", equalTo(1))
                .body("status", equalTo("success"));
    }
}
