package com.example.androidbootcampassignment6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidbootcampassignment6.databinding.CategoryRowBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories){
        this.categories = categories;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CategoryRowBinding binding;

        public ViewHolder(CategoryRowBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryRowBinding binding = CategoryRowBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.binding.categoryName.setText(categories.get(position).name.toString());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
