package com.karenkgs.recipesAPI.ingredient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientFactory {
    public static List<Ingredient> ingredients() {
        return new ArrayList<>(Arrays.asList(
                new Ingredient("Ham", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Cheese", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Bread", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Butter", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Bacon", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Eggs", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Mushrooms", LocalDate.parse("2018-10-30"), LocalDate.parse("2018-11-02")),
                new Ingredient("Sausage", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Hotdog Bun", LocalDate.parse("2018-10-30"), LocalDate.parse("2018-11-14")),
                new Ingredient("Ketchup", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Mustard", LocalDate.parse("2018-11-14"), LocalDate.parse("2018-11-19")),
                new Ingredient("Lettuce", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Tomato", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Cucumber", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Beetroot", LocalDate.parse("2018-11-09"), LocalDate.parse("2018-11-14")),
                new Ingredient("Salad Dressing", LocalDate.parse("2018-10-30"), LocalDate.parse("2018-11-02"))
        ));
    }

    public static Ingredient ingredientByTitle(String title) {
        return ingredients().stream().filter(ingredient -> ingredient.getTitle().equals(title)).findFirst().orElse(null);
    }
}
