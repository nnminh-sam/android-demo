package nnminh.android.nguyennhatminhn21dccn053;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductListAdapter productListAdapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_list_fragment, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewProductList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList = getSampleProducts();
        productListAdapter = new ProductListAdapter(productList, getContext());
        recyclerView.setAdapter(productListAdapter);

        return view;
    }

    private List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 1", "5 minutes", "$15.00", "Meat Pizza", 0));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 2", "10 minutes", "$12.10", "Cheese Pizza", 0));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 3", "12 minutes", "$18.13", "Ham Pizza", 1));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 4", "18 minutes", "$18.12", "Special Pizza", 3));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 5", "5 minutes", "$15.00", "Meat Pizza", 0));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 6", "10 minutes", "$12.10", "Cheese Pizza", 0));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 7", "12 minutes", "$18.13", "Ham Pizza", 1));
        products.add(new Product("https://thepizzacompany.vn/images/thumbs/000/0002218_sup-deluxe.png", "Pizza 8", "18 minutes", "$18.12", "Special Pizza", 3));
        return products;
    }
}