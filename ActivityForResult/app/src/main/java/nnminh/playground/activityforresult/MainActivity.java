package nnminh.playground.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] listButtonID = { R.id.btnChangeBottom, R.id.btnChangeTop };
    TextView txtTop, txtBottom;
    public static final int REQUEST_CODE_TOP = 999;
    public static final int REQUEST_CODE_BOTTOM = 998;
    public static final int RESULT_CODE_UPPER = 100;
    public static final int RESULT_CODE_LOWER = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void init() {
        txtTop = findViewById(R.id.txtTitleTop);
        txtBottom = findViewById(R.id.txtTitleBottm);

        for (int id: listButtonID) {
            Button btn = (Button) findViewById(id);
            btn.setOnClickListener(this);
        }
    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnChangeBottom) {
            Intent intentChangeBottom = new Intent(MainActivity.this, ActivityResult.class);
            startActivityForResult(intentChangeBottom, REQUEST_CODE_BOTTOM);
        } else if (id == R.id.btnChangeTop) {
            Intent intentChangeTop = new Intent(MainActivity.this, ActivityResult.class);
            startActivityForResult(intentChangeTop, REQUEST_CODE_TOP);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String title = data.getStringExtra("yourTitle");
        if (requestCode == REQUEST_CODE_TOP) {
            if (resultCode == RESULT_CODE_UPPER) txtTop.setText(title.toUpperCase());
            if (resultCode == RESULT_CODE_LOWER) txtTop.setText(title.toLowerCase());
        }
        if (requestCode == REQUEST_CODE_BOTTOM) {
            if (resultCode == RESULT_CODE_UPPER) txtBottom.setText(title.toUpperCase());
            if (resultCode == RESULT_CODE_LOWER) txtBottom.setText(title.toLowerCase());
        }
    }
}