package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.IngredientRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeFactory {

    private static final IngredientRepository ingredientRepository = new IngredientRepository();

    public static List<Recipe> recipes() {
        return new ArrayList<>(Arrays.asList(
                new Recipe("Ham and Cheese Toastie", new ArrayList<>(Arrays.asList(
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Cheese"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Bread"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Butter")))),

                new Recipe("Fry-up", new ArrayList<>(Arrays.asList(
                        ingredientRepository.findIngredientFromFactoryByTitle("Bacon"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Eggs"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Baked Beans"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Mushrooms"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Sausage")))),

                new Recipe("Salad", new ArrayList<>(Arrays.asList(
                        ingredientRepository.findIngredientFromFactoryByTitle("Lettuce"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Tomato"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Cucumber"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Beetroot"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Salad Dressing")))),

                new Recipe("Hotdog", new ArrayList<>(Arrays.asList(
                        ingredientRepository.findIngredientFromFactoryByTitle("Hotdog Bun"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Sausage"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ketchup"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Mustard")))),

                new Recipe("Omelette", new ArrayList<>(Arrays.asList(
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"),
                        ingredientRepository.findIngredientFromFactoryByTitle("Ham"))))
        ));
    }
}
