package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lunch")
@RestController
public class LunchRestController {

    @Autowired
    private LunchService lunchService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    List<Recipe> getRecipesByIngredients(@RequestParam(name = "ingredients") List<String> ingredients) {
        return lunchService.getRecipesByIngredients(ingredients);
    }
}