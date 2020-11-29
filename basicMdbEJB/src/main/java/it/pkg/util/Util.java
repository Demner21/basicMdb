package it.pkg.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

public class Util {
  private static Logger logger = Logger.getLogger(Util.class);

  public final static String SALTOLINEA = "\n";


  public static int leerInteger(String cadena) {
    int numero = 0;
    try {
      numero = Integer.parseInt(cadena);
    } catch (NumberFormatException e) {
      numero = 0;
    }
    return numero;
  }

  public static String generarIdTransaccion() {
    return new Date().getTime() + "";
  }

  public static String convertirNumeroActividadAString(int actividad) {
    String sActividad;
    if (actividad < 10) {
      sActividad = "0" + actividad;
    } else {
      sActividad = Integer.toString(actividad);
    }
    return sActividad;
  }

  public static String getIp() {
    String ip = null;
    try {
      ip = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      logger.error(e.getMessage(), e);
    }
    return ip;
  }

  public static String retornaValorString(ResultSet rs, String nombreColumna) throws SQLException {

    if (null != rs.getString(nombreColumna)) {
      return rs.getString(nombreColumna);
    } else {
      return Constantes.VACIO;
    }
  }



}