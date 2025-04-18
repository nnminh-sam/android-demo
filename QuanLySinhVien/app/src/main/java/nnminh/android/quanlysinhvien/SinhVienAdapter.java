package nnminh.android.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> sinhVienList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public SinhVienAdapter(Context context, List<SinhVien> sinhVienList) {
        this.context = context;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return sinhVienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_sinhvien_items, null);
        }

        TextView txtMaSV = convertView.findViewById(R.id.txtMaSV);
        TextView txtHotenSV = convertView.findViewById(R.id.txtHotenSV);
        TextView txtNgaySinh = convertView.findViewById(R.id.txtNgaySinh);

        SinhVien sinhVien = sinhVienList.get(position);
        txtMaSV.setText(sinhVien.getId());
        txtHotenSV.setText(sinhVien.getHoten());
        txtNgaySinh.setText(dateFormat.format(sinhVien.getNgaysinh()));

        return convertView;
    }
}
