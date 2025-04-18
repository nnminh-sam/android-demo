package nnminh.android.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
    private SQLiteDatabase db;

    public SinhVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public long insert(SinhVien sinhVien) {
        ContentValues values = new ContentValues();
        values.put("id", sinhVien.getId());
        values.put("hoten", sinhVien.getHoten());
        values.put("ngaysinh", DateTimeHelper.toString(sinhVien.getNgaysinh()));
        values.put("lophocid", sinhVien.getLopHocId());
        return db.insert("sinhviens", null, values);
    }

    public List<SinhVien> getAllByLopHoc(int lopHocId) throws ParseException {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM sinhviens WHERE lophocid = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(lopHocId)});
        while (cursor.moveToNext()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(cursor.getString(cursor.getColumnIndexOrThrow("id")));
            sinhVien.setHoten(cursor.getString(cursor.getColumnIndexOrThrow("hoten")));
            sinhVien.setNgaysinh(DateTimeHelper.toDate(cursor.getString(cursor.getColumnIndexOrThrow("ngaysinh"))));
            sinhVien.setLopHocId(cursor.getInt(cursor.getColumnIndexOrThrow("lophocid")));
            list.add(sinhVien);
        }
        cursor.close();
        return list;
    }
}
