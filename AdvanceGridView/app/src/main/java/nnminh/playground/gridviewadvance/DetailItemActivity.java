package nnminh.playground.gridviewadvance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView txtDetailName = findViewById(R.id.txtDetailName);
        TextView txtDetailPrice = findViewById(R.id.txtDetailPrice);
        TextView txtDetailDiscount = findViewById(R.id.txtDetailDiscount);
        Button btnBack = findViewById(R.id.btnBack);

        // Get Data from Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("item")) {
            Item item = (Item) intent.getSerializableExtra("item");

            txtDetailName.setText(item.getName());
            txtDetailPrice.setText("$" + item.getPrice());
            imgDetail.setImageResource(item.getImageResId());

            if (item.getDiscount() != null && !item.getDiscount().isEmpty()) {
                txtDetailDiscount.setText(item.getDiscount());
                txtDetailDiscount.setVisibility(View.VISIBLE);
            } else {
                txtDetailDiscount.setVisibility(View.GONE);
            }
        }

        // Handle Back Button
        btnBack.setOnClickListener(view -> finish());
    }

}