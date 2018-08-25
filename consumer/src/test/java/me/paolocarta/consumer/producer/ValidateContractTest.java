package me.paolocarta.consumer.producer;


import me.paolocarta.consumer.client.Movie;
import me.paolocarta.consumer.client.RestClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"me.paolocarta.contract:producer:+:stubs:8888"}, stubsMode = StubsMode.LOCAL)
public class ValidateContractTest {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private RestClient restClient;

    @Test
    public void validateMoviePublished() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(getUrl("movies/10/status"),
                                                                            String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo("{\"published\":true}");
    }

    @Test
    public void validateMoviePublishedWithFeign() {

        Movie movie = restClient.getMovieStatus(10);

        assertThat(movie).isNotNull();
        assertThat(movie.isPublished()).isTrue();
    }

    @Test
    public void validateMovieNotPublished() {

        ResponseEntity<String> responseEntity =  restTemplate.getForEntity(getUrl("movies/22/status"),
                                                                        String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
       assertThat(responseEntity.getBody()).isEqualTo("{\"published\":false}");

    }

    private String getUrl(String path){
        return String.format("http://localhost:8888/%s", path);
    }
}
