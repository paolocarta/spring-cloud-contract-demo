package me.paolocarta.producer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MoviesRestController {

    @GetMapping(value = "movies/{movieId}/status", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> getPaymentStatus(@PathVariable int movieId) {

        if (movieId > 20) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(new Movie(false));
        }
        return ResponseEntity.ok(new Movie(true));

    }
}
