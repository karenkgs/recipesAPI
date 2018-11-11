package com.karenkgs.recipesAPI.recipe;

import com.karenkgs.recipesAPI.ingredient.Ingredient;

import java.util.Collections;
import java.util.List;

public class Recipe implements Comparable {
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

  @Override
  public int compareTo(Object o) {
    Recipe otherRecipe = (Recipe) o;
    Collections.sort(ingredients);
    Collections.sort(otherRecipe.getIngredients());

    if (ingredients.get(0).getBestBefore().isAfter(otherRecipe.ingredients.get(0).getBestBefore())) {
      return -1;
    } else if (ingredients.get(0).getBestBefore().isBefore(otherRecipe.ingredients.get(0).getBestBefore())) {
      return 1;
    } else {
      return 0;
    }
  }
}
