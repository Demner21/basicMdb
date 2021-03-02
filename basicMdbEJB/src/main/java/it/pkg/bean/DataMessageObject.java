package it.pkg.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataType")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataMessageObject implements Serializable {
  private static final long serialVersionUID = 1L;

  private String idTransaccion;

  public String getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(String idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

}