package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.Ingredient;

import java.util.List;

public class Recipe {
    private final String title;
    private final List<Ingredient> ingredients;

    public Recipe(String title, List<Ingredient> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }
}
