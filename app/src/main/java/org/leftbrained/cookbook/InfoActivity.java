package org.leftbrained.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import org.leftbrained.cookbook.databinding.ActivityInfoBinding;
import org.leftbrained.cookbook.databinding.ActivityListBinding;
import org.leftbrained.cookbook.model.RecipeViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInfoBinding binding = ActivityInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        RecipeViewModel viewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        viewModel.initializeRecipes();
        viewModel.recipes.forEach(
                recipe -> {
                    if (recipe.getName().equals(getIntent().getStringExtra("name"))) {
                        binding.infoImage.setImageResource(recipe.getLargeImage());
                        binding.infoDesc.setText(getRecipeText(recipe.getRecipe()));
                        binding.infoName.setText(recipe.getName());
                    }
                }
        );
    }

    public String getRecipeText(int resourceId) {
        InputStream inputStream = getResources().openRawResource(resourceId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}