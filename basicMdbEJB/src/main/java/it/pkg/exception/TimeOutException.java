package it.pkg.exception;

public class TimeOutException extends BaseException {

  /**
   * 
   */
  private static final long serialVersionUID = -2977252727315778685L;

  public TimeOutException(Exception objException) {
    super(objException);
  }

  public TimeOutException(String msjError) {
    super(msjError);
  }

  public TimeOutException(String codError, String msjError, Exception objException) {
    super(codError, msjError, objException);
  }

  public TimeOutException(int codError, String msjError, String nombreSP, String nombreBD, Exception objException) {
    super(codError, msjError, nombreSP, nombreBD, objException);
  }

}
