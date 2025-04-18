package nnminh.android.quanlysinhvien;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTenLopHoc;
    private Button btnLuuLopHoc, btnHuyLopHoc;
    private ListView lvDanhMucLopHoc;
    private LopHocAdapter lopHocAdapter;
    private List<LopHoc> lopHocList;
    private LopHocDAO lopHocDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        lopHocDAO = new LopHocDAO(this);
        loadLopHocList();
    }

    private void initViews() {
        edtTenLopHoc = findViewById(R.id.edtTenLopHoc);
        btnLuuLopHoc = findViewById(R.id.btnLuuLopHoc);
        btnHuyLopHoc = findViewById(R.id.btnHuyLopHoc);
        lvDanhMucLopHoc = findViewById(R.id.lvDanhMucLopHoc);

        btnLuuLopHoc.setOnClickListener(this);
        btnHuyLopHoc.setOnClickListener(this);
    }

    private void loadLopHocList() {
        lopHocList = lopHocDAO.getAll();
        lopHocAdapter = new LopHocAdapter(this, lopHocList);
        lvDanhMucLopHoc.setAdapter(lopHocAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLuuLopHoc:
                LopHoc lopHoc = new LopHoc();
                lopHoc.setTenLopHoc(edtTenLopHoc.getText().toString());
                long result = lopHocDAO.insert(lopHoc);
                if (result > 0) {
                    loadLopHocList();
                    edtTenLopHoc.setText("");
                    Toast.makeText(this, "Luu lop hoc thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Luu lop hoc that bai", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnHuyLopHoc:
                finish();
                break;
        }
    }
}