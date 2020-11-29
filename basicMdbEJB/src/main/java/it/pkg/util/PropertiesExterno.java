package it.pkg.util;

import java.io.Serializable;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesExterno implements Serializable{
  
  private static final long serialVersionUID = 1L;
  @Value( "${db.dmneru.jndi}" )
  public String             demneruJndi;
  @Value( "${db.dmneru.timeoutConexion}" )
  public Integer            dmneruTimeOutConexion;
  @Value( "${db.dmneru.timeoutejecucion}" )
  public Integer            demneruTimeOutEjecucion;
  @Value( "${db.dmneru.owner}" )
  public String             dmneruOwner;
  @Value( "${db.dmnru.sp.test}" )
  public String             spNameComplete;
  @Value( "${respuesta.codigo.exito}" )
  public String             respuestaCodigoExito;
}