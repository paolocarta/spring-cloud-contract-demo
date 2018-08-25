package me.paolocarta.producer;

import me.paolocarta.producer.controllers.MoviesRestController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class MockMvcTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new MoviesRestController());
    }
}
