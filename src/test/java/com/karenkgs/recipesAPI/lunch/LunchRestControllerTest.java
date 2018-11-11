package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.ingredient.Ingredient;
import com.karenkgs.recipesAPI.recipe.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LunchRestControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private LunchService lunchService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldReturnErrorWithNoParametersOnURL() throws Exception {
    mvc.perform(get("/lunch"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void shouldReturnHamAndCheeseToastieRecipeWithHamCheeseButterAndBreadIngredientsOnURL() throws Exception {
    List<Ingredient> ingredientsAsObjects = Arrays.asList(
        new Ingredient("Ham", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
        new Ingredient("Cheese", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
        new Ingredient("Bread", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
        new Ingredient("Butter", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"))
    );

    List<String> ingredientsAsString = Arrays.asList(
        "ham",
        "cheese",
        "bread",
        "butter"
    );

    List<Recipe> recipes = Arrays.asList(new Recipe("Ham and Cheese Toastie", ingredientsAsObjects));

    when(lunchService.getRecipesByIngredients(ingredientsAsString)).thenReturn(recipes);

    mvc.perform(get("/lunch?ingredients=ham,cheese,bread,butter")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$[0].title").value(recipes.get(0).getTitle()))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldNotReturnRecipesWithPastUseByDateIngredientsOnURL() throws Exception {
    List<String> ingredientsAsString = Arrays.asList(
        "salad Dressing",
        "mushrooms"
    );

    when(lunchService.getRecipesByIngredients(ingredientsAsString)).thenReturn(new ArrayList<>());

    mvc.perform(get("/lunch?ingredients=salad dressing, mushrooms"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }

  @Test
  public void shouldOrderRecipesByItsIngredientsBestBeforeDates() throws Exception {
    Ingredient sweetCondensedMilk = new Ingredient("Sweet condensed milk", LocalDate.parse("2018-11-13"), LocalDate.parse("2018-11-19"));
    Ingredient butter = new Ingredient("Butter", LocalDate.parse("2018-11-12"), LocalDate.parse("2018-11-19"));
    Ingredient chocolate = new Ingredient("Chocolate", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19"));
    Ingredient shreddedCoconut = new Ingredient("Shredded coconut", LocalDate.parse("2018-11-11"), LocalDate.parse("2018-11-19"));
    Ingredient popcorn = new Ingredient("Popcorn", LocalDate.parse("2018-11-10"), LocalDate.parse("2018-11-19"));

    List<String> ingredientsAsString = Arrays.asList(
        "chocolate",
        "sweet condensed milk",
        "shredded coconut",
        "butter",
        "popcorn"
    );

    List<Recipe> recipes = Arrays.asList(
        new Recipe("Pipoca doce", Arrays.asList(sweetCondensedMilk, chocolate, popcorn)),
        new Recipe("Brigadeiro", Arrays.asList(sweetCondensedMilk, butter, chocolate)),
        new Recipe("Beijinho", Arrays.asList(sweetCondensedMilk, shreddedCoconut, butter))
    );

    Collections.sort(recipes);

    when(lunchService.getRecipesByIngredients(ingredientsAsString)).thenReturn(recipes);

    mvc.perform(get("/lunch?ingredients=chocolate,sweet condensed milk,shredded coconut,butter,popcorn")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$[0].title").value("Brigadeiro"))
        .andExpect(jsonPath("$[1].title").value("Beijinho"))
        .andExpect(jsonPath("$[2].title").value("Pipoca doce"))
        .andExpect(status().isOk());
  }
}
