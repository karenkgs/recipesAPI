package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.recipe.Recipe;
import com.karenkgs.recipesAPI.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LunchService {
    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findRecipesFromFactory();
    }
}
