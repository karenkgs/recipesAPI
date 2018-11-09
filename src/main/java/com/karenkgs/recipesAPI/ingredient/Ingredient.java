package com.karenkgs.recipesAPI.ingredient;

import java.time.LocalDate;

public class Ingredient {
    private String title;
    private LocalDate bestBefore;
    private LocalDate useBy;

    public Ingredient(String title, LocalDate bestBefore, LocalDate useBy) {
        this.title = title;
        this.bestBefore = bestBefore;
        this.useBy = useBy;
    }

    public String getTitle() {
        return title;
    }
}
