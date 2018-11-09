package com.karenkgs.recipesAPI.lunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LunchRestController {

    @Autowired
    private LunchService lunchService;

    @RequestMapping("/lunch")
    public String getRecipesWithoutIngredients() {
        return "You have to pass the ingredients from your fridge.";
    }
}