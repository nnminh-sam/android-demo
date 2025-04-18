package nnminh.playground.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResult extends AppCompatActivity implements View.OnClickListener {

    private int[] listButtonId2 = {R.id.btnChangeLower, R.id.btnChangeUpper};
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        init1();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void init1() {
        editText = findViewById(R.id.edtTitle);
        for (int id: listButtonId2) {
            Button btn = (Button) findViewById(id);
            btn.setOnClickListener(this);
        }
    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();

        if (TextUtils.isEmpty(editText.getText().toString())) {
            showToast("Empty data");
        }
        else {
            if (v.getId() == R.id.btnChangeUpper) {
                intent.putExtra("yourTitle", editText.getText().toString());
                setResult(MainActivity.RESULT_CODE_UPPER, intent);
                finish();
            }
            else {
                intent.putExtra("yourTitle", editText.getText().toString());
                setResult(MainActivity.RESULT_CODE_LOWER, intent);
                finish();
            }
        }
    }
}