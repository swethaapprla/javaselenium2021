import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DeleteCallTest {
    @Test
    public void deleteTest() {

        given()
                .baseUri("http://dummy.restapiexample.com/api/v1/delete/719")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .body("message", equalTo("Successfully! Record has been deleted"));
    }
}
