package cn.njit.myapplication.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String process(String string) {
        Date date = new Date();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = fmt.parse(string);
        } catch (Exception e) {

        }
        return fmt.format(date);
    }
}
