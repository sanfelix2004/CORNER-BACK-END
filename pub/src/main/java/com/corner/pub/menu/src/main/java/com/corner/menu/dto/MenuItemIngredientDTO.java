package com.corner.menu.dto;

public class MenuItemIngredientDTO {

    private String ingredientName;
    private Long quantity;

    // Costruttore
    public MenuItemIngredientDTO() {}

    public MenuItemIngredientDTO(String ingredientName, Long quantity) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}