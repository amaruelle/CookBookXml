package org.leftbrained.cookbook.model;

public class RecipeList {
    private int icon;
    private String name;

    private int recipe;
    private int largeImage;

    public RecipeList(String name, int icon, int recipe, int largeImage) {
        this.name = name;
        this.icon = icon;
        this.recipe = recipe;
        this.largeImage = largeImage;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecipe() {
        return recipe;
    }

    public void setRecipe(int recipe) {
        this.recipe = recipe;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(int largeImage) {
        this.largeImage = largeImage;
    }

}
