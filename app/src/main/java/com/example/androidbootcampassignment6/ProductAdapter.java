package com.example.androidbootcampassignment6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidbootcampassignment6.databinding.ProductRowBinding;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    ArrayList<Product> products;
    Context mContext;


    public ProductAdapter(ArrayList<Product> products,Context mContext) {
        this.products = products;
        this.mContext = mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ProductRowBinding binding;

        public ViewHolder(ProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductRowBinding binding = ProductRowBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.productNameTv.setText(products.get(position).productName);
        holder.binding.productDescriptionTv.setText(products.get(position).productDescription);
        holder.binding.productPriceTv.setText(products.get(position).productPrice);
        holder.binding.productIv.setImageResource(mContext.getResources()
                .getIdentifier(products.get(position).getImageName(),"drawable",mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
