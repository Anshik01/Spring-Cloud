package com.movie.Catelog.controller;

import com.movie.Catelog.model.CatelogItem;
import com.movie.Catelog.model.Movie;
import com.movie.Catelog.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catelog")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userName}")
    public List<CatelogItem> getMovies(@PathVariable String userName){

        UserRating ratings = restTemplate.getForObject("http://Rating/rating/user/" + userName, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://MovieInfo/movies/" + rating.getMovieName(), Movie.class);

                    return new CatelogItem(movie.getMovieName(), movie.getDesc(), rating.getRating());
        })
                .collect(Collectors.toList());

    }

}

