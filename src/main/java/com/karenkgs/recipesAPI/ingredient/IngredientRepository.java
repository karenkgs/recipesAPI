package com.karenkgs.recipesAPI.ingredient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {

  @Autowired
  private ObjectMapper objectMapper;

  public List<Ingredient> findAll() {
    try {
      InputStream is = IngredientWrapper.class.getResourceAsStream("/ingredients.json");
      IngredientWrapper ingredientWrapper = objectMapper.readValue(is, new TypeReference<IngredientWrapper>() {
      });
      return ingredientWrapper.getIngredients();
    } catch (IOException exception) {
      System.out.println("Problem:" + exception.getMessage() + " " + exception.getCause() + exception.getStackTrace());
    }
    return new ArrayList<>();
  }

  public Ingredient findIngredientByTitle(String title) {
    return findAll().stream().filter(ingredient -> ingredient.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
  }
}
