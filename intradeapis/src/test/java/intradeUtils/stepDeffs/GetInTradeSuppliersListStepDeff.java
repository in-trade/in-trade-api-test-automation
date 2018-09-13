package intradeUtils.stepDeffs;

import codeUtil.EnviUriConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class GetInTradeSuppliersListStepDeff {

    private URI uri;
    private RequestSpecification requestSpec;
    private Response response;

    @Given("^I have setup an EndPoint for the Suppliers$")
    public void i_have_setup_an_EndPoint_for_the_Suppliers() throws Throwable {

        String urlfromconfig = EnviUriConfig.getHostedEnnValue();
        System.out.println(urlfromconfig);

        String endPointSuppliers = urlfromconfig+"/suppliers";
        uri = new URI(endPointSuppliers);

        requestSpec =

                given();

        requestSpec.headers("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik1qZENSa0V4TkRRMFJUZzFRVUk1T1RsRE9UUkNOa05GTURJMU9EQkVRa1JGTnpNNE56QkdRdyJ9.eyJodHRwOi8vaW50cmFkZS9yb2xlcyI6WyJzdXBlckFkbWluIl0sImlzcyI6Imh0dHBzOi8vaW50cmFkZS1xYS5ldS5hdXRoMC5jb20vIiwic3ViIjoiYXV0aDB8NWI2ZDU2MDA2MGU4NGEwZmJlNjk0NWRlIiwiYXVkIjpbImh0dHBzOi8vaW50cmFkZS8iLCJodHRwczovL2ludHJhZGUtcWEuZXUuYXV0aDAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTUzNTk4MTQ0MywiZXhwIjoxNTM1OTg4NjQzLCJhenAiOiI3bVdFcE0wRXdPZkpsM3JRemxjNUF6ckhpWjJnNlgxcSIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwifQ.i7G27cmhxodph7STgl8h0gv3Is7y_GqL8a06wI9ZiUj0gX_UN4eF0NneZnBEDavV5frHSA39WjSAQunQvWMqZ-I2wnlLZGaE-anU-N5guhOi6W37bJFjldp5oLwchRknsglPtFBKuQaIhJbvMp9125UCVIeNq2sLwftrfVMBWRci0n1bacvKol9DS8Wcu4KBMHsoysunjcs1OE-5v5aSEcqtca0sBBFNSOBii8BrLxm1O7blO9wmShqfH1B6u7r-9nNW8VmxlD7ZOXs_BJFBhS9DQs2LCwN_XiJs2q-7J4tc8xpN0_zYm7M8IEdau-TykxCE5NL1ZuArMrRV-UCurQ")
                        .accept(ContentType.ANY)
                        .contentType("application/json");

    }

    @When("^I perform a GET call$")
    public void i_perform_a_GET_call() throws Throwable {

        response = requestSpec
                .when()
                .get(uri);

    }

    @Then("^I should see a list of available categories and valid response code\\.$")
    public void i_should_see_a_list_of_available_categories_and_valid_response_code() throws Throwable {

        response
                .then()
                .log().all()
                .statusCode(200);

    }

}
