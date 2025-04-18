package nnminh.playground.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("AAA", "Start main activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("AAA", "On Restart main activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("AAA", "onResume main activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("AAA", "onPause main activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("AAA", "onStop main activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AAA", "onDestroy main activity");
    }

    public void toActivity1(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void closeActivity2(View view) {
        finish();
    }
}