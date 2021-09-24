package com.example.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.example.models.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class JuiceShopTest extends BaseTest {

    @Test
    public void createCustomerSuccessfully(TestInfo testInfo) {

        ExtentTest extentTest = extentReports.createTest(testInfo.getDisplayName());
        extentTest.log(Status.INFO, testInfo.getDisplayName() + " - started");

        try {
            int UserId = given().spec(requestSpecification)
                    .and()
                    .body(customerBuilder())
                    .post("api/users")
                    .then()
                    .assertThat().statusCode(201)
                    .extract().path("data.id");
        } catch (Exception e) {

            extentTest.fail(MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
            System.out.println("tests " + testInfo.getDisplayName() + " failed");
            System.out.println("exception => " + e.getLocalizedMessage());
            e.printStackTrace();
        }

    }

    @Test
    public void performDefaultSearch() {
        getSearchResults(null)
                .then()
                .assertThat().statusCode(200)
                .body("status", is("success"))
                .body("data", is(not(empty())))
                .body("data[0].id", is(not(notANumber())))
                .body("data[0].image", containsString(".jpeg"));
    }

    @Test
    public void addProductToCart() {
        Authentication authentication = login("Ezra.Gleichner3@yahoo.com", "password")
                .then()
                .assertThat().statusCode(200)
                .extract().as(LoginResponse.class).getAuthentication();

        int productId = getSearchResults(null)
                .then()
                .assertThat().statusCode(200)
                .body("data", is(not(empty())))
                .extract().path("data[0].id");

        addProductToBasket(productId, authentication.getBid(), 1, authentication.getToken())
                .then()
                .assertThat().statusCode(200)
                .body("status", is("success"))
                .body("data.BasketId", is(String.valueOf(authentication.getBid())))
                .body("data.ProductId", is(productId))
                .body("data.quantity", is(1));
    }

    private Response addProductToBasket(int productId, int basketId, int quantity, String token) {
        JSONObject basketRequestBody = new JSONObject();
        basketRequestBody.put("ProductId", productId);
        basketRequestBody.put("BasketId", String.valueOf(basketId));
        basketRequestBody.put("quantity", quantity);

        return given().spec(requestSpecification)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(basketRequestBody)
                .post("api/BasketItems/");
    }

    private Response login(String email, String password) {
        JSONObject loginRequestBody = new JSONObject();
        loginRequestBody.put("email", email);
        loginRequestBody.put("password", password);

        return given().spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(loginRequestBody)
                .post("rest/user/login");
    }

    private Response getSearchResults(String searchTerm) {
        return given().spec(requestSpecification)
                .when()
                .queryParam("q", searchTerm)
                .get("rest/products/search");
    }

    private SecurityAnswers securityAnswerBuilder(int userId, int questionId, String answer) {
        return SecurityAnswers.builder().answer(answer).SecurityQuestionId(questionId)
                .UserId(userId).build();
    }

    private Customer customerBuilder() {
        return Customer.builder()
                .email(faker.bothify("????##@gmail.com"))
                .password("password")
                .passwordRepeat("password")
                .securityQuestion(SecurityQuestion.builder()
                        .createdAt("2020-05-03T08:51:58.696Z")
                        .updatedAt("2020-05-03T08:51:58.696Z")
                        .question("Your eldest siblings middle name?")
                        .build())
                .securityAnswer("asdf").build();
    }
}
