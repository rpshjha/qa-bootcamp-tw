package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 23/09/21
 * Time: 7:36 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpotifyTest {

    private String clientId = "4cef6deaba8745fbb81ea653413a54fc";
    private String clientSecret = "eac2b60a89664a529dd4d537dcdc4907";

    private String accessToken;

    @BeforeAll
    public void setup() {
        accessToken = "Bearer BQBDzQ8UbaNi7mynDolBs2uxABmxAJZqk4eRYbEuGKDUOSUo0y9QtaEiDFqiN9s-0TDo_hfKn94U9tevl5clBd3ImuP1c-S2AthKQZyop-MFrJLgh92XI1rlIMWrRMTt9sIBBTWtWexomDDj3RTA6-t1P7fRaeNlNxycmuQvOq0TVA6kOS_4_yRoDrZNuixvabGsOS7y7dLVuBTHg2XXsuK-zZtuuXY5EILp3t8dXuKHY3hhSxZJn6tbhiWkrkncBDwjxCllIldGiaBRgYZkB5vq4hPwYNAIF6_sKAqliPw_DV8HtssLjp6GDYAR";
    }

    @Test
    public void addMusicToPlaylist() {

        String trackUriToBeAdded = searchTracks("dil hai");
        addTracks(trackUriToBeAdded);
        Assertions.assertTrue(getTracksFromPlaylist().containsValue(trackUriToBeAdded));

    }

    String searchTracks(String searchTerm) {
        List<Map> response = given().when()
                .log()
                .all()
                .baseUri("https://api-partner.spotify.com/pathfinder/v1/query")
                .and()
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .and()
                .queryParam("operationName", "searchDesktop")
                .queryParam("variables", "{\"searchTerm\":\"" + searchTerm + "\",\"offset\":0,\"limit\":10,\"numberOfTopResults\":5}")
                .queryParam("extensions", "{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"75bbf6bfcfdf85b8fc828417bfad92b7cd66bf7f556d85670f4da8292373ebec\"}}")
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .and().extract()
                .path("data.search.tracks.items");

        Map<String, String> tracks = new HashMap<>();
        for (Map temp : response) {
            tracks.put(((HashMap) temp.get("track")).get("name").toString(), ((HashMap) temp.get("track")).get("uri").toString());
        }
        Map.Entry<String, String> randomTrack = tracks.entrySet().stream().findAny().get();
        System.out.println("track to be added is : " + randomTrack.getKey());
        return randomTrack.getValue();
    }


    void addTracks(String uriTrack) {
        given().when()
                .log()
                .all()
                .baseUri("https://api.spotify.com/v1/playlists/1vslWnZchxOU7PfDBZixwU/tracks")
                .and()
                .header("Authorization", accessToken)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("{\n" +
                        "    \"uris\": [\n" +
                        "        \"" + uriTrack + "\"\n" +
                        "    ],\n" +
                        "    \"position\": null\n" +
                        "}")
                .post()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);
    }

    void deleteTracks(String uriTrack) {

    }

    Map<String, String> getTracksFromPlaylist() {
        List<Map> response = given().when()
                .log()
                .all()
                .baseUri("https://api.spotify.com/v1/playlists/1vslWnZchxOU7PfDBZixwU/tracks")
                .and()
                .header("Authorization", accessToken)
                .and()
                .queryParam("market", "from_token")
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().path("items");

        Map<String, String> tracks = new HashMap<>();

        for (Map temp : response) {
            tracks.put(((HashMap) temp.get("track")).get("name").toString(), ((HashMap) temp.get("track")).get("uri").toString());
        }
        return tracks;
    }


    private String getUserAccessToken() {
        RestAssured.baseURI = "https://accounts.spotify.com";
        String authValue = "Basic " + encodeStringToBase64(clientId + ":" + clientSecret);

        String accessToken = given().log().all()
                .when()
                .header("Authorization", authValue)
                .and()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .post("/api/token")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("access_token").toString();

        return "Bearer " + accessToken;
    }

    private String encodeStringToBase64(String token) {
        byte[] encodedBytes = Base64.encodeBase64(token.getBytes());
        return new String(encodedBytes).trim();
    }
}
