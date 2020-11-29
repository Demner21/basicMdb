package it.pkg.bean;

import java.io.Serializable;

public class ResponseRegistrarTransaccionBean implements Serializable {
  private static final long serialVersionUID = 1L;

  private String codigoError;
  private String mensajeError;

  public String getCodigoError() {
    return codigoError;
  }

  public void setCodigoError(String kCodError) {
    this.codigoError = kCodError;
  }

  public String getMensajeError() {
    return mensajeError;
  }

  public void setMensajeError(String kMsgError) {
    this.mensajeError = kMsgError;
  }
}
