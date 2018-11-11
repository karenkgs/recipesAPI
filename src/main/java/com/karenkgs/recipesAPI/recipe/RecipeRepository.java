package com.karenkgs.recipesAPI.recipe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karenkgs.recipesAPI.ingredient.Ingredient;
import com.karenkgs.recipesAPI.ingredient.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private IngredientRepository ingredientRepository;

  public List<Recipe> findAll() {
    try {
      InputStream recipesJson = RecipeWrapper.class.getResourceAsStream("/recipes.json");
      RecipeWrapper recipeWrapper = objectMapper.readValue(recipesJson, new TypeReference<RecipeWrapper>() {
      });

      return updateIngredientsObjects(recipeWrapper.getRecipes());
    } catch (IOException exception) {
      System.out.println("Problem" + exception.getMessage() + " " + exception.getCause() + exception.getStackTrace());
    }
    return new ArrayList<>();
  }

  private List<Recipe> updateIngredientsObjects(List<Recipe> recipes) {
    for (Recipe recipe : recipes) {
      for (Ingredient ingredient : recipe.getIngredients()) {
        Ingredient repositoryIngredient = ingredientRepository.findIngredientByTitle(ingredient.getTitle());
        if (null != repositoryIngredient) {
          ingredient.setUseBy(repositoryIngredient.getUseBy());
          ingredient.setBestBefore(repositoryIngredient.getBestBefore());
        }
      }
    }
    return recipes;
  }

  public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
    List<Recipe> recipes = new ArrayList<>();

    for (Recipe recipe : findAll()) {
      if (recipe.getIngredients().stream().allMatch((Ingredient::isValid))
          && ingredients.containsAll(recipe.getIngredients())) {
        recipes.add(recipe);
      }
    }
    return recipes;
  }
}
