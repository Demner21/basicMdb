package it.pkg.exception;

public class DBException extends BaseException {

  private static final long serialVersionUID = 756863187125064820L;

  public DBException(String mensajeError) {
    super(mensajeError);
  }

  public DBException(String mensajeError, Throwable e) {
    super(mensajeError, e);
  }

  public DBException(int codigoError, String mensajeError, Throwable e) {
    super(codigoError, mensajeError, e);
  }

  public DBException(String codigoError, String mensajeError, Throwable e) {
    super(codigoError, mensajeError, e);
  }

}
