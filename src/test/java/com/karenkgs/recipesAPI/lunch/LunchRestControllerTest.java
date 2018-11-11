package com.karenkgs.recipesAPI.lunch;

import com.karenkgs.recipesAPI.ingredient.Ingredient;
import com.karenkgs.recipesAPI.recipe.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Mock
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
                "Ham",
                "Cheese",
                "Bread",
                "Butter"
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
                "Salad Dressing",
                "Mushrooms"
        );

        when(lunchService.getRecipesByIngredients(ingredientsAsString)).thenReturn(new ArrayList<>());

        mvc.perform(get("lunch?ingredients=salad dressing, mushrooms"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
