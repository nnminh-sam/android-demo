package nnminh.android.quanlysinhvien;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVienActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtMaSV, edtHotenSV, edtNgaySinhSV;
    private ListView lvDanhsachSinhvien;
    private Spinner spLopHoc;
    private Button btnLuSinhVien, btnThoatSinhVien;
    private SinhVienAdapter sinhVienAdapter;
    private List<LopHoc> lopHocList;
    private List<SinhVien> sinhVienList;
    private LopHocDAO lopHocDAO;
    private SinhVienDAO sinhVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sinh_vien);

        initViews();
        lopHocDAO = new LopHocDAO(this);
        sinhVienDAO = new SinhVienDAO(this);

        loadLopHocToSpinner();
        fillSinhVienListView();
    }

    private void initViews() {
        edtMaSV = findViewById(R.id.edtMaSV);
        edtHotenSV = findViewById(R.id.edtHotenSV);
        edtNgaySinhSV = findViewById(R.id.edtNgaySinhSV);
        lvDanhsachSinhvien = findViewById(R.id.lvDanhsachSinhvien);
        spLopHoc = findViewById(R.id.spLopHoc);
        btnLuSinhVien = findViewById(R.id.btnLuSinhVien);
        btnThoatSinhVien = findViewById(R.id.btnThoatSinhVien);

        btnLuSinhVien.setOnClickListener(this);
        btnThoatSinhVien.setOnClickListener(this);

        spLopHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillSinhVienListView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void loadLopHocToSpinner() {
        lopHocList = lopHocDAO.getAll();
        LopHocAdapter lopHocAdapter = new LopHocAdapter(this, lopHocList);
        spLopHoc.setAdapter(lopHocAdapter);
    }

    private void fillSinhVienListView() {
        try {
            int lopHocId = lopHocList.get(spLopHoc.getSelectedItemPosition()).getId();
            sinhVienList = sinhVienDAO.getAllByLopHoc(lopHocId);
            sinhVienAdapter = new SinhVienAdapter(this, sinhVienList);
            lvDanhsachSinhvien.setAdapter(sinhVienAdapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading students", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLuSinhVien:
                try {
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.setId(edtMaSV.getText().toString());
                    sinhVien.setHoten(edtHotenSV.getText().toString());
                    sinhVien.setNgaysinh(DateTimeHelper.toDate(edtNgaySinhSV.getText().toString()));
                    int lopHocPosition = spLopHoc.getSelectedItemPosition();
                    sinhVien.setLopHocId(lopHocList.get(lopHocPosition).getId());

                    long result = sinhVienDAO.insert(sinhVien);
                    if (result > 0) {
                        fillSinhVienListView();
                        edtMaSV.setText("");
                        edtHotenSV.setText("");
                        edtNgaySinhSV.setText("");
                        Toast.makeText(this, "Sinh vien da duoc luu", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Luu sinh vien that bai", Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error parsing date", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnThoatSinhVien:
                finish();
                break;
        }
    }
}