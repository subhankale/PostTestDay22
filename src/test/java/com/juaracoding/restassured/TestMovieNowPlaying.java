package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestMovieNowPlaying {

    String endpoint = "https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1";

    @Test
    public void testStatusCode(){
        Response response = RestAssured.get(endpoint);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        Assert.assertEquals(response.getStatusCode(),401);
    }

    @Test
    public void testIdOne(){
        given()
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(1));
    }
    @Test
    public void testIdTwo(){
        given()
                .then()
                .statusCode(200)
                .body("data.id[1]", equalTo(2));
    }
}
