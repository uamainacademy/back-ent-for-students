package com.brainacad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateHelper {

  public static String getCurrentDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm", Locale.US);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return dateFormat.format(new Date());
  }

}
