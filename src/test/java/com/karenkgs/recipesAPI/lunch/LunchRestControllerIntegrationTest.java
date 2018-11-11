package com.karenkgs.recipesAPI.lunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LunchRestControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void shouldNotReturnRecipesWithPastUseByDateIngredientsOnURL() throws Exception {
    mvc.perform(get("/lunch?ingredients=salad dressing, mushrooms"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnErrorWithNoParametersOnURL() throws Exception {
    mvc.perform(get("/lunch"))
        .andExpect(status().is4xxClientError());
  }

  @Test
  public void shouldReturnErrorWithNonExistingIngredientOnURL() throws Exception {
    mvc.perform(get("/lunch?ingredients=doesnt exist"))
        .andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnHamAndCheeseToastieRecipeWithHamCheeseButterAndBreadIngredientsOnURL() throws Exception {
    mvc.perform(get("/lunch?ingredients=ham,cheese,bread,butter")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$[0].title").value("Ham and Cheese Toastie"))
        .andExpect(status().isOk());
  }
}
