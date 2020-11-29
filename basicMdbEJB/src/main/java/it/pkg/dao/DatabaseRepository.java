package it.pkg.dao;

import it.pkg.bean.RequestRegistrarTransaccionBean;
import it.pkg.bean.ResponseRegistrarTransaccionBean;
import it.pkg.exception.DBException;
import it.pkg.exception.TimeOutException;

public interface DatabaseRepository {

  public ResponseRegistrarTransaccionBean registrarTransaccion(String mensajeLog,
                                                            RequestRegistrarTransaccionBean request) 
                                                             throws DBException, TimeOutException;

}
