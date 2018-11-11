package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.ingredient.Ingredient;
import com.karenkgs.recipesAPI.ingredient.IngredientRepository;
import com.karenkgs.recipesAPI.recipe.Recipe;
import com.karenkgs.recipesAPI.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LunchService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Recipe> getRecipesByIngredients(List<String> ingredients) {
        List<Ingredient> ingredientsFromString = ingredients.stream().map(
                ingredientRepository::findIngredientByTitle)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if(null == ingredientsFromString || ingredientsFromString.isEmpty()){
            return new ArrayList<>();
        }
        return recipeRepository.findRecipesByIngredients(ingredientsFromString);
    }
}
