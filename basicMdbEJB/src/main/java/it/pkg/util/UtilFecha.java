package it.pkg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Logger;

public class UtilFecha {

  private static Logger logger = Logger.getLogger(UtilFecha.class);

  public static String dateToString(Date fechaDate) {

    return dateToStringConFormato(fechaDate, Constantes.FORMATO_FECHA_DEFAULT);

  }

  public static String dateToStringConFormato(Date fechaDate, String formato) {
    String fechaString = null;

    if (fechaDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
      fechaString = simpleDateFormat.format(fechaDate);
    }

    return fechaString;
  }
  
  public static String dateToStringConFormatoYZonaHoraria(Date fechaDate, String formato, String timeZone) {
    String fechaString = null;
    
    if (fechaDate != null) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
      simpleDateFormat.setTimeZone( TimeZone.getTimeZone( timeZone ) );
      fechaString = simpleDateFormat.format(fechaDate);
    }
    
    return fechaString;
  }

  public static Date stringToDate(String fechaString) {
    return stringToDate(fechaString, Constantes.FORMATO_FECHA_DEFAULT);
  }

  public static Date stringToDate(String fechaString, String formato) {

    Date fechaDate = null;

    if (fechaString != null) {

      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
      try {
        fechaDate = simpleDateFormat.parse(fechaString);
      } catch (ParseException e) {
        logger.info("Error al parsear fecha: " + fechaString + " a formato " + formato + ": " + e.getMessage(), e);
      }
    }

    return fechaDate;

  }

}
