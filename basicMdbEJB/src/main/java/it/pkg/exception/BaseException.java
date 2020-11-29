package it.pkg.exception;

public class BaseException extends Exception {

  private static final long serialVersionUID = 5246661617731285863L;
  private Exception objException;
  private int codError;
  private String codigoError;
  private String msjError;
  private String nombreSP;
  private String nombreBD;
  private String nombreWS;
  private String nombreQueue;

  public BaseException() {
    super();
  }

  public BaseException(String mensajeError, Throwable e) {
    super(mensajeError, e);
    this.msjError = mensajeError;
  }

  public BaseException(Exception objException) {
    super(objException);
    this.objException = objException;
  }

  public BaseException(String msjError) {
    super(msjError);
    this.msjError = msjError;
  }

  public BaseException(String codigoError, String mensajeError, Throwable e) {
    super(mensajeError, e);
    this.codigoError = codigoError;
    this.msjError = mensajeError;
  }

  public BaseException(int codigoError, String mensajeError, Throwable e) {
    super(mensajeError, e);
    this.codError = codigoError;
    this.msjError = mensajeError;
  }

  public BaseException(int codigoError, String mensajeError) {
    super(mensajeError);
    this.codError = codigoError;
    this.msjError = mensajeError;
  }

  public BaseException(String msjError, Exception objException) {
    super(objException);
    this.objException = objException;
    this.msjError = msjError;
  }

  public BaseException(int codError, String msjError, Exception objException) {
    super(msjError);
    this.codError = codError;
    this.msjError = msjError;
    this.objException = objException;
  }

  public BaseException(int codError, String msjError, String nombreSP, String nombreBD, Exception objException) {
    super(msjError);
    this.codError = codError;
    this.msjError = msjError;
    this.nombreSP = nombreSP;
    this.nombreBD = nombreBD;
    this.objException = objException;
  }

  public BaseException(int codError, String msjError, String nombreWS, Exception objException) {
    super(msjError);
    this.codError = codError;
    this.msjError = msjError;
    this.nombreWS = nombreWS;
    this.objException = objException;
  }

  public BaseException(String codError, String msjError, String nombreWS, Exception objException) {
    super(msjError);
    this.codigoError = codError;
    this.msjError = msjError;
    this.nombreWS = nombreWS;
    this.objException = objException;
  }

  public Exception getObjException() {
    return objException;
  }

  public void setObjException(Exception objException) {
    this.objException = objException;
  }

  public int getCodError() {
    return codError;
  }

  public void setCodError(int codError) {
    this.codError = codError;
  }

  public String getCodigoError() {
    return codigoError;
  }

  public void setCodigoError(String codigoError) {
    this.codigoError = codigoError;
  }

  public String getMsjError() {
    return msjError;
  }

  public void setMsjError(String msjError) {
    this.msjError = msjError;
  }

  public String getNombreSP() {
    return nombreSP;
  }

  public void setNombreSP(String nombreSP) {
    this.nombreSP = nombreSP;
  }

  public String getNombreBD() {
    return nombreBD;
  }

  public void setNombreBD(String nombreBD) {
    this.nombreBD = nombreBD;
  }

  public String getNombreWS() {
    return nombreWS;
  }

  public void setNombreWS(String nombreWS) {
    this.nombreWS = nombreWS;
  }

  public String getNombreQueue() {
    return nombreQueue;
  }

  public void setNombreQueue(String nombreQueue) {
    this.nombreQueue = nombreQueue;
  }

}
