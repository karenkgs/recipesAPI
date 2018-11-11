package com.karenkgs.recipesAPI.ingredient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class Ingredient implements Comparable {
  private String title;
  @JsonProperty("best-before")
  private LocalDate bestBefore;
  @JsonProperty("use-by")
  private LocalDate useBy;

  public Ingredient() {

  }

  public Ingredient(String title) {
    this.title = title;
  }

  public Ingredient(String title, LocalDate bestBefore, LocalDate useBy) {
    this.title = title;
    this.bestBefore = bestBefore;
    this.useBy = useBy;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getBestBefore() {
    return bestBefore;
  }

  public void setBestBefore(LocalDate bestBefore) {
    this.bestBefore = bestBefore;
  }

  public void setUseBy(LocalDate useBy) {
    this.useBy = useBy;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getUseBy() {
    return useBy;
  }

  @JsonIgnore
  public boolean isValid() {
    return null != useBy && null != title && null != bestBefore && isNotSpoiled();
  }

  @JsonIgnore
  public boolean isNotSpoiled() {
    return useBy.plusDays(1).isAfter(LocalDate.now());
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

  @Override
  public int compareTo(Object o) {
    return bestBefore.compareTo(((Ingredient) o).getBestBefore());
  }
}
