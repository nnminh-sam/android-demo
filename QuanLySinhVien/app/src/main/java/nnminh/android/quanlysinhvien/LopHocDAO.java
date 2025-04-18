package nnminh.android.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LopHocDAO {
    private SQLiteDatabase db;

    public LopHocDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public long insert(LopHoc lopHoc) {
        ContentValues values = new ContentValues();
        values.put("tenlop", lopHoc.getTenLopHoc());
        return db.insert("lophocs", null, values);
    }

    public List<LopHoc> getAll() {
        List<LopHoc> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM lophocs", null);
        while (cursor.moveToNext()) {
            LopHoc lopHoc = new LopHoc();
            lopHoc.setId(cursor.getInt(0));
            lopHoc.setTenLopHoc(cursor.getString(1));
            list.add(lopHoc);
        }
        cursor.close();
        return list;
    }
}
