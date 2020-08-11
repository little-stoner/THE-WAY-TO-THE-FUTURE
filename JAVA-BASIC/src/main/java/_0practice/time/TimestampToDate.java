package _0practice.time;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * https://stackoverflow.com/questions/8237193/how-to-convert-currenttimemillis-to-a-date-in-java
 * https://stackoverflow.com/questions/4673527/converting-milliseconds-to-a-date-jquery-javascript
 */


public class TimestampToDate {


    public static void main(String[] args) {

        long t = 1596988800000L;

        convertToLocalDate(t);

    }

    public static void convertToDate(long timestamp) {
        Timestamp ts = new Timestamp(timestamp);
        Date date = new Date(ts.getTime());
        System.out.println(date);
    }

    public static void convertToLocalDate(long timestamp) {
        Timestamp ts = new Timestamp(timestamp);
        LocalDateTime localDate = ts.toLocalDateTime();
        System.out.println(localDate);
    }






}
