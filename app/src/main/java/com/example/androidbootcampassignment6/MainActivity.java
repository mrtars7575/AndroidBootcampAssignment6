package com.example.androidbootcampassignment6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.androidbootcampassignment6.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Category> categories;
    ArrayList<Product> products;
    ProductAdapter productAdapter;
    CategoryAdapter categoryAdapter;
    List<SlideModel> slideModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //category

        categories = new ArrayList<>();

        categories.add(new Category(1,"KOLONYA"));
        categories.add(new Category(2,"KOLONYALI MENDİL"));
        categories.add(new Category(3,"KİŞİSEL BAKIM"));
        categories.add(new Category(4,"BEBEK"));
        categories.add(new Category(5,"EV BAKIMI"));
        categories.add(new Category(6,"DEZENFEKTAN"));

        //carousel

        slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.carousel1, ScaleTypes.FIT));

        binding.slider.setImageList(slideModels,ScaleTypes.FIT);

        //product

        products = new ArrayList<>();

        products.add(new Product(1,"EYUP SABRI TUNCER","Manolya Desenli Poşet (Küçük Boy)"
                ,"40","product1"));

        products.add(new Product(1,"EYUP SABRI TUNCER","Manolya Desenli Poşet (Küçük Boy)"
                ,"80","product2"));

        products.add(new Product(1,"EYUP SABRI TUNCER","Manolya Desenli Poşet (Küçük Boy)"
                ,"35","product3"));

        products.add(new Product(1,"EYUP SABRI TUNCER","Manolya Desenli Poşet (Küçük Boy)"
                ,"120","product4"));


        //category recycler view

        binding.categoryRv.setLayoutManager(new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.HORIZONTAL
        ));
        categoryAdapter = new CategoryAdapter(categories);
        binding.categoryRv.setAdapter(categoryAdapter);

        //product recycler view

        binding.productRv.setLayoutManager(new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.HORIZONTAL
        ));
        productAdapter = new ProductAdapter(products,getApplicationContext());
        binding.productRv.setAdapter(productAdapter);





    }
}