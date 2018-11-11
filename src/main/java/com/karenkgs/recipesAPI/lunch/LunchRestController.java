package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lunch")
@RestController
public class LunchRestController {

    @Autowired
    private LunchService lunchService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    ResponseEntity<List<Recipe>> getRecipesByIngredients(@RequestParam(name = "ingredients") List<String> ingredients) {
        final List<Recipe> recipes = lunchService.getRecipesByIngredients(ingredients);
        if (null == recipes || recipes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}