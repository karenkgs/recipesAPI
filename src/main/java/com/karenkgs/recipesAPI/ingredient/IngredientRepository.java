package com.karenkgs.recipesAPI.ingredient;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientRepository {
    public List<Ingredient> findAllIngredientsFromFactory() {
        return IngredientFactory.ingredients();
    }

    public Ingredient findIngredientFromFactoryByTitle(String title) {
        return findAllIngredientsFromFactory().stream().filter(ingredient -> ingredient.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
