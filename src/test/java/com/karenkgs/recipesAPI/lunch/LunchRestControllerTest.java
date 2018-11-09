package com.karenkgs.recipesAPI.lunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LunchRestController.class)
public class LunchRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LunchService service;

    @Test
    public void shouldReturnErrorMessageWithNoParametersOnURL() throws Exception {
        mvc.perform(get("/lunch"))
                .andExpect(content().string("You have to pass the ingredients from your fridge."))
                .andExpect(status().isOk());
    }
}
