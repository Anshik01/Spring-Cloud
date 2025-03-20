package com.MovieInfo.controller;

import com.MovieInfo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class Controller {

//    @Value("${api.key}")
//    private String apiKey;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/{movieName}")
    public Movie getMovie(@PathVariable String movieName){
        return new Movie(movieName, "best anime");
    }

}
