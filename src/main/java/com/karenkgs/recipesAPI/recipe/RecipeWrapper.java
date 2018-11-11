package com.karenkgs.recipesAPI.recipe;

import java.util.List;

public class RecipeWrapper {
  private List<Recipe> recipes;

  public RecipeWrapper() {
  }

  public RecipeWrapper(List<Recipe> recipes) {
    this.recipes = recipes;
  }

  public List<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }
}
