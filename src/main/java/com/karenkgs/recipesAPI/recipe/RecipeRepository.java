package com.karenkgs.recipesAPI.recipe;

import java.util.List;

public class RecipeRepository {
    public List<Recipe> findRecipesFromFactory() {
        return RecipeFactory.recipes();
    }
}
