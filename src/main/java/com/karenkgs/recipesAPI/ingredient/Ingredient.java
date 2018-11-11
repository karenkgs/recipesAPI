package com.karenkgs.recipesAPI.ingredient;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(title.toLowerCase(), that.title.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }
}
