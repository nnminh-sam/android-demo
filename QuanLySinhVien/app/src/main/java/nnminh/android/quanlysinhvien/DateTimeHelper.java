package nnminh.android.quanlysinhvien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {
    private static String PATTERN = "dd/MM/yyyy";

    public static Date toDate(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        return sdf.parse(str);
    }

    public static String toString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        return sdf.format(date);
    }
}
