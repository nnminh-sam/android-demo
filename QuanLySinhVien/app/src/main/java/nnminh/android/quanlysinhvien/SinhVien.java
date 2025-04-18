package nnminh.android.quanlysinhvien;

import java.util.Date;

public class SinhVien {
    private String id;
    private String hoten;
    private Date ngaysinh;
    private int lopHocId;

    public SinhVien() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }
    public Date getNgaysinh() { return ngaysinh; }
    public void setNgaysinh(Date ngaysinh) { this.ngaysinh = ngaysinh; }
    public int getLopHocId() { return lopHocId; }
    public void setLopHocId(int lopHocId) { this.lopHocId = lopHocId; }
}
