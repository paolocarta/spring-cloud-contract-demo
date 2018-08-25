package me.paolocarta.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "restClient", url = "http://localhost:8888", configuration = RestClientConfig.class)
public interface RestClient {

	@GetMapping(value = "/movies/{movieId}/status", consumes = MediaType.APPLICATION_JSON_VALUE)
	Movie getMovieStatus(@PathVariable(name = "movieId") int movieId);
}
