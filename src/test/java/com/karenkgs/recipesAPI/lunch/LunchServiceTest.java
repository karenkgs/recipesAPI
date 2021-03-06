package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.ingredient.Ingredient;
import com.karenkgs.recipesAPI.ingredient.IngredientRepository;
import com.karenkgs.recipesAPI.recipe.Recipe;
import com.karenkgs.recipesAPI.recipe.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


public class LunchServiceTest {
  @Mock
  RecipeRepository recipeRepository;

  @Mock
  IngredientRepository ingredientRepository;

  @InjectMocks
  LunchService lunchService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldReturnHamAndCheeseToastieRecipeWithHamCheeseButterAndBreadParameters() {

    Ingredient ham = new Ingredient("Ham", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"));
    Ingredient cheese = new Ingredient("Cheese", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"));
    Ingredient bread = new Ingredient("Bread", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"));
    Ingredient butter = new Ingredient("Butter", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"));

    when(ingredientRepository.findIngredientByTitle("ham")).thenReturn(ham);
    when(ingredientRepository.findIngredientByTitle("cheese")).thenReturn(cheese);
    when(ingredientRepository.findIngredientByTitle("butter")).thenReturn(butter);
    when(ingredientRepository.findIngredientByTitle("bread")).thenReturn(bread);

    when(recipeRepository.findAll()).thenReturn(Arrays.asList(new Recipe("Ham and Cheese Toastie", Arrays.asList(ham, cheese, bread, butter))));

    when(recipeRepository.findRecipesByIngredients(Arrays.asList(ham, cheese, butter, bread))
    ).thenReturn(Arrays.asList(
        new Recipe("Ham and Cheese Toastie",
            Arrays.asList(
                ham,
                cheese,
                butter,
                bread
            ))
        )
    );

    Recipe resultRecipe = lunchService.getRecipesByIngredients(Arrays.asList("ham", "cheese", "butter", "bread")).get(0);

    assertThat(resultRecipe.getTitle(), is("Ham and Cheese Toastie"));
  }
}
