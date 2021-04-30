package story;

import base.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityTest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import steps.ReusableSteps;

import java.util.Arrays;
import java.util.List;

@SerenityTest
class CurrencyTest extends TestBase {

    @Steps
    ReusableSteps steps;

    @ParameterizedTest
    @CsvSource(value = {"INR:Bhutan,India,Zimbabwe","LKR:Sri Lanka"}, delimiter = ':')
    @Title("Search countries by currency")
    void searchByCurrency(String currency, String country) {
        //Given
        List<String> countries = Arrays.asList(country.split(","));
        //When
        Response response = steps.getResponse("/currency/", currency);
        //Then
        steps.assertStatusCode(EXPECTED_CODE, response);
        steps.assertContentType(EXPECTED_CONTENT_TYPE, response);
        steps.assertCurrencyCountries(countries, currency, response);

    }


}
