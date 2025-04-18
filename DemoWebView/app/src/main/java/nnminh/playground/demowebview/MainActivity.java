package nnminh.playground.demowebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.edUrl);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goBack(View view) {
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }

    public void goForward(View view) {
        if (webView.canGoForward()) {
            webView.goForward();
        }
    }

    public void goReload(View view) {
        webView.reload();
    }

    public void goToWebSite(View view) {
        webView.loadUrl(url.getText().toString());
    }
}