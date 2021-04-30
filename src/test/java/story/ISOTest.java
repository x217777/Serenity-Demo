package story;

import base.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.junit5.SerenityTest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import steps.ReusableSteps;

@SerenityTest
class ISOTest extends TestBase {

    @Steps
    ReusableSteps steps;

    @ParameterizedTest
    @CsvSource(value = {"IND:India", "USA:United States of America"}, delimiter = ':')
    @Title("Search countries by alpha3 code")
    void searchByAlpha3Code(String alpha3Code,String countryName) {
        //When
        Response response = steps.getResponse("/alpha/", alpha3Code);
        //Then
        steps.assertStatusCode(EXPECTED_CODE, response);
        steps.assertContentType(EXPECTED_CONTENT_TYPE, response);
        steps.assertCountryName(countryName, response);
        steps.assertAlpha3Code(alpha3Code, response);

    }

    @ParameterizedTest
    @CsvSource(value = {"IN:India", "US:United States of America"}, delimiter = ':')
    @Title("Search countries by alpha2 code")
    void searchByAlpha2Code(String alpha2Code,String countryName) {
        //When
        Response response = steps.getResponse("/alpha/", alpha2Code);
        //Then
        steps.assertStatusCode(EXPECTED_CODE, response);
        steps.assertContentType(EXPECTED_CONTENT_TYPE, response);
        steps.assertCountryName(countryName, response);
        steps.assertAlpha2Code(alpha2Code, response);

    }

}
