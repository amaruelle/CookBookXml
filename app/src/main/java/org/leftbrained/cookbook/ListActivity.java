package org.leftbrained.cookbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;

import org.leftbrained.cookbook.databinding.ActivityListBinding;
import org.leftbrained.cookbook.model.RecipeAdapter;
import org.leftbrained.cookbook.model.RecipeList;
import org.leftbrained.cookbook.model.RecipeViewModel;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecipeViewModel viewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        viewModel.initializeRecipes();
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        RecipeAdapter adapter = new RecipeAdapter(viewModel.recipes);
        binding.listView.setAdapter(adapter);
        binding.listView.setLayoutManager(new WearableLinearLayoutManager(this));
    }
}