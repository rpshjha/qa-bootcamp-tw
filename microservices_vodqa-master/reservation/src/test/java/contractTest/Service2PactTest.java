package contractTest;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Service2PactTest
{
    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("flightdetails", "localhost", 9090, this);

    @Pact(consumer = "reservation")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws JsonProcessingException, ParseException {

        String jsonInString = "{\n" +
                "    \"flightNumber\": \"aa1\",\n" +
                "    \"operatingAirlines\": \"american airlines\",\n" +
                "    \"departureCity\": \"aus\",\n" +
                "    \"arrivalCity\": \"nyc\",\n" +
                "    \"dateOfDeparture\": 1517769000000,\n" +
                "    \"estimatedDepartureTime\": 1517780647000,\n" +
                "    \"id\": 1\n" +
                "  }";

        return builder
                .given("test GET flights")
                .uponReceiving("GET REQUEST")
                .path("/findFlight/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(jsonInString).toPact();

    }

    @Test
    @PactVerification()
    public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {

        // when
        ResponseEntity<String> response = new RestTemplate()
                .getForEntity(mockProvider.getUrl() + "/findFlight/1", String.class);
        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).contains("flightNumber", "operatingAirlines", "departureCity", "arrivalCity");
    }
}
