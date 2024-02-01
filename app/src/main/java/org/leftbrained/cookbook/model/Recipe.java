package org.leftbrained.cookbook.model;

public class Recipe {
    private int image;
    private int icon;
    private int text;

    public Recipe(int image, int icon, int text) {
        this.image = image;
        this.icon = icon;
        this.text = text;
    }

    public int getText() {
        return text;
    }

    public void setText(int text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
