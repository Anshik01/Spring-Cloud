package com.Rating.controller;

import com.Rating.model.Rating;
import com.Rating.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class Controller {

    @GetMapping("/{movieName}")
    public Rating getRating(@PathVariable String movieName){
        return new Rating(movieName, "10");
    }

    @GetMapping("user/{userName}")
    public UserRating getUserRating(@PathVariable String userName){
        List<Rating> ratings = Arrays.asList(
                new Rating("Dragon Ball", "9"),
                new Rating("Death Note", "10")
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
