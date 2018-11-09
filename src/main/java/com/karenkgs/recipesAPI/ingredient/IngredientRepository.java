package com.karenkgs.recipesAPI.ingredient;

import java.util.List;

public class IngredientRepository {
    public List<Ingredient> findAllIngredientsFromFactory() {
        return IngredientFactory.ingredients();
    }

    public Ingredient findIngredientFromFactoryByTitle(String title) {
        return IngredientFactory.ingredientByTitle(title);
    }
}
