package it.pkg.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesExterno implements Serializable{
  
  private static final long serialVersionUID = 1L;
  @Value( "${db.dmnru.jndi}" )
  public String             demneruJndi;
  @Value( "${db.dmnru.timeoutConexion}" )
  public Integer            dmneruTimeOutConexion;
  @Value( "${db.dmnru.timeoutejecucion}" )
  public Integer            demneruTimeOutEjecucion;
  @Value( "${db.dmnru.owner}" )
  public String             dmneruOwner;
  @Value( "${db.dmnru.sp.test}" )
  public String             spNameComplete;
  @Value( "${respuesta.codigo.exito}" )
  public String             respuestaCodigoExito;
}