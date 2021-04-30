package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ReusableSteps {

    @Step("#get response by {0}")
    public Response getResponse(String resource, String searchBy) {
        return SerenityRest.when().get(resource + searchBy);

    }

    @Step("#Status code should be {0}")
    public void assertStatusCode(int expectedCode, Response response) {
        Assertions.assertEquals(expectedCode, response.getStatusCode());
    }

    @Step("#Content type should be {0}")
    public void assertContentType(String expectedContentType, Response response) {
        Assertions.assertEquals(expectedContentType, response.getContentType());
    }

    @Step("#Country name should be {0}")
    public void assertCountryName(String expectedCountryName, Response response) {
        Assertions.assertEquals(expectedCountryName, response.getBody().jsonPath().get("name"));
    }

    @Step("#Alpha2 code should be {0}")
    public void assertAlpha2Code(String expectedAlphaCode, Response response) {
        Assertions.assertEquals(expectedAlphaCode, response.getBody().jsonPath().get("alpha2Code"));
    }

    @Step("#Alpha3 code should be {0}")
    public void assertAlpha3Code(String expectedAlphaCode, Response response) {
        Assertions.assertEquals(expectedAlphaCode, response.getBody().jsonPath().get("alpha3Code"));
    }

    @Step("#Countries: {0} should have {1} currency")
    public void assertCurrencyCountries(List<String> countries, String currency, Response response) {
        List<String> actualCountries = response.getBody().jsonPath().getList("name");
        Assertions.assertEquals(countries, actualCountries);
    }
}
