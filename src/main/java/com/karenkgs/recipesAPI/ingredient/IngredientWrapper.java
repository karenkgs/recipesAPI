package com.karenkgs.recipesAPI.ingredient;

import java.util.List;

public class IngredientWrapper {
  private List<Ingredient> ingredients;

  public IngredientWrapper() {

  }

  public IngredientWrapper(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
