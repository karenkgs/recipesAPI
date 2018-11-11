package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.IngredientFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeFactory {

    public static List<Recipe> recipes() {
        return new ArrayList<>(Arrays.asList(
                new Recipe("Ham and Cheese Toastie", new ArrayList<>(Arrays.asList(
                        IngredientFactory.ingredientByTitle("Ham"),
                        IngredientFactory.ingredientByTitle("Cheese"),
                        IngredientFactory.ingredientByTitle("Bread"),
                        IngredientFactory.ingredientByTitle("Butter")))),

                new Recipe("Fry-up", new ArrayList<>(Arrays.asList(
                        IngredientFactory.ingredientByTitle("Bacon"),
                        IngredientFactory.ingredientByTitle("Eggs"),
                        IngredientFactory.ingredientByTitle("Baked Beans"),
                        IngredientFactory.ingredientByTitle("Mushrooms"),
                        IngredientFactory.ingredientByTitle("Sausage")))),

                new Recipe("Salad", new ArrayList<>(Arrays.asList(
                        IngredientFactory.ingredientByTitle("Lettuce"),
                        IngredientFactory.ingredientByTitle("Tomato"),
                        IngredientFactory.ingredientByTitle("Cucumber"),
                        IngredientFactory.ingredientByTitle("Beetroot"),
                        IngredientFactory.ingredientByTitle("Salad Dressing")))),

                new Recipe("Hotdog", new ArrayList<>(Arrays.asList(
                        IngredientFactory.ingredientByTitle("Hotdog Bun"),
                        IngredientFactory.ingredientByTitle("Sausage"),
                        IngredientFactory.ingredientByTitle("Ketchup"),
                        IngredientFactory.ingredientByTitle("Mustard")))),

                new Recipe("Omelette", new ArrayList<>(Arrays.asList(
                        IngredientFactory.ingredientByTitle("Eggs"),
                        IngredientFactory.ingredientByTitle("Mushroom"),
                        IngredientFactory.ingredientByTitle("Milk"),
                        IngredientFactory.ingredientByTitle("Salt"),
                        IngredientFactory.ingredientByTitle("Pepper"),
                        IngredientFactory.ingredientByTitle("Spinach"))))
        ));
    }
}
