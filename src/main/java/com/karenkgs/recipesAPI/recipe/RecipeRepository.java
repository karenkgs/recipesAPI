package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeRepository {
    public List<Recipe> findRecipesFromFactory() {
        return RecipeFactory.recipes();
    }

    public Recipe findRecipeByTitle(String title) {
        return findRecipesFromFactory().stream().filter(recipe -> recipe.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public List<Recipe> findRecipesFromFactoryByIngredients(List<Ingredient> ingredients) {
        return RecipeFactory.recipes().stream().filter(recipe -> recipe.getIngredients().containsAll(ingredients)).collect(Collectors.toList());
    }
}
