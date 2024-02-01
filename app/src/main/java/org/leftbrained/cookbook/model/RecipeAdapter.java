package org.leftbrained.cookbook.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.WearableRecyclerView;

import org.leftbrained.cookbook.InfoActivity;
import org.leftbrained.cookbook.ListActivity;
import org.leftbrained.cookbook.R;

import java.util.List;

public class RecipeAdapter extends WearableRecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<RecipeList> recipes;

    public RecipeAdapter(List<RecipeList> recipes) {
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_view, parent,
                false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        RecipeList iterable = recipes.get(position);
        holder.name.setText(iterable.getName());
        holder.icon.setImageResource(iterable.getIcon());

        holder.itemView.setOnClickListener((View.OnClickListener) v -> {
            String name = recipes.get(position).getName();
            Intent intent = new Intent(v.getContext(), InfoActivity.class);
            intent.putExtra("name", name);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends WearableRecyclerView.ViewHolder {
        private ImageView icon;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.itemName);
        }
    }
}
