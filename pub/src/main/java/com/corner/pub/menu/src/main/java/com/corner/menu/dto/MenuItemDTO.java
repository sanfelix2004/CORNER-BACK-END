package com.corner.menu.dto;

import java.math.BigDecimal;
import java.util.List;

public class MenuItemDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private List<MenuItemIngredientDTO> ingredients;

    // Costruttore
    public MenuItemDTO() {}

    public MenuItemDTO(Long id, String name, String description, BigDecimal price, Long categoryId, List<MenuItemIngredientDTO> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.ingredients = ingredients;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<MenuItemIngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<MenuItemIngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}