package nnminh.playground.gridviewadvance;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.myGrid);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 999.99, R.drawable.bg1, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg2, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg3, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg4, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg5, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg6, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg7, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg8, "20% OFF"));
        items.add(new Item("Laptop", 999.99, R.drawable.bg9, "20% OFF"));

        GridAdapter adapter = new GridAdapter(this, items, R.layout.grid_item);
        gridView.setAdapter(adapter);
    }
}