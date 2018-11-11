package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.Ingredient;

import java.util.List;

public class Recipe {
    private String title;
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String title, List<Ingredient> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
