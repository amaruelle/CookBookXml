package org.leftbrained.cookbook.model;

import androidx.lifecycle.ViewModel;

import org.leftbrained.cookbook.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeViewModel extends ViewModel {
    public List<RecipeList> recipes = new ArrayList<>();

    public void initializeRecipes() {
        recipes.add(new RecipeList("Блинчик", R.drawable.ic_blinchik, R.raw.blinchik, R.drawable.blinchik));
        recipes.add(new RecipeList("Борщ", R.drawable.ic_borsch, R.raw.borsch, R.drawable.borsch));
        recipes.add(new RecipeList("Цезарь", R.drawable.ic_cesar, R.raw.cesar, R.drawable.cesar));
        recipes.add(new RecipeList("Милкшейк", R.drawable.ic_milkshake, R.raw.milkshake, R.drawable.milkshake));
        recipes.add(new RecipeList("Спагетти", R.drawable.ic_spagetti, R.raw.spagetti, R.drawable.spagetti));
    }
}
