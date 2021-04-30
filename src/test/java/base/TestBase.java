package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static final String EXPECTED_CONTENT_TYPE = "application/json;charset=utf-8";
    public static final int EXPECTED_CODE = 200;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://restcountries.eu/rest/v2";
        RestAssured.when().get("/callingcode/372");

    }
}
