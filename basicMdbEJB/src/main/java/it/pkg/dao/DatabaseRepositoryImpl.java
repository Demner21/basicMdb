package it.pkg.dao;

import static oracle.jdbc.OracleTypes.CLOB;
import static oracle.jdbc.OracleTypes.DATE;
import static oracle.jdbc.OracleTypes.VARCHAR;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import it.pkg.bean.RequestRegistrarTransaccionBean;
import it.pkg.bean.ResponseRegistrarTransaccionBean;
import it.pkg.exception.DBException;
import it.pkg.exception.TimeOutException;
import it.pkg.util.Constantes;
import it.pkg.util.PropertiesExterno;

@Repository
public class DatabaseRepositoryImpl implements DatabaseRepository {
  
  private static final Logger logger = Logger.getLogger(DatabaseRepositoryImpl.class);

  @Autowired
  @Qualifier("eruDatasource")
  private DataSource eruDataSource;

  @Autowired
  private PropertiesExterno propertiesExterno;

  @Override
  public ResponseRegistrarTransaccionBean registrarTransaccion(String mensajeLog,
      RequestRegistrarTransaccionBean request) throws DBException, TimeOutException {
    long tiempoInicio = System.currentTimeMillis();
    long tiempoFin = 0;
    ResponseRegistrarTransaccionBean response = new ResponseRegistrarTransaccionBean();
    String sp = propertiesExterno.spNameComplete;

    logger.info(mensajeLog + "===Inicio del metodo registrarTransaccion-DAO===");

    try {
      eruDataSource.setLoginTimeout(propertiesExterno.dmneruTimeOutConexion);
      
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(eruDataSource)
                                          .withoutProcedureColumnMetaDataAccess()
                                          .withSchemaName(propertiesExterno.dmneruOwner)
                                          .withProcedureName(sp)
                                          .declareParameters(new SqlParameter("PARAMETER_VARCHAR", VARCHAR),
                                                              new SqlParameter("PARAMETER_CLOB", CLOB),
                                                              new SqlParameter("PARAMETER_DATE", DATE),
                                                              new SqlOutParameter("PARAMETER_SALIDA", VARCHAR));

      logger.info(mensajeLog + "Consultando DemneruDatabase, con JNDI=" + propertiesExterno.demneruJndi);
      logger.info(mensajeLog + "Tiempo permitido de ejecucion=" + propertiesExterno.demneruTimeOutEjecucion);
      
      simpleJdbcCall.getJdbcTemplate()
                    .setQueryTimeout(propertiesExterno.demneruTimeOutEjecucion);

      logger.info(mensajeLog + "Ejecutando SP : " + sp);
      logger.info(mensajeLog + Constantes.PARAMETRO_IN + " PARAMETER_VARCHAR: " + request.getParameterVarchar());
      logger.info(mensajeLog + Constantes.PARAMETRO_IN + " PARAMETER_CLOB: " + request.getParameterBlob());
      logger.info(mensajeLog + Constantes.PARAMETRO_IN + " PARAMETER_DATE: " + request.getParameterDate());

      SqlParameterSource objParametrosIN = new MapSqlParameterSource()
          .addValue("PARAMETER_VARCHAR", request.getParameterVarchar())
          .addValue("PARAMETER_CLOB", request.getParameterBlob())
          .addValue("PARAMETER_DATE", request.getParameterDate());

      Map<String, Object> resultMap = simpleJdbcCall.execute(objParametrosIN);
      response.setMensajeError(resultMap.get("PARAMETER_SALIDA").toString());

      logger.info(mensajeLog + "Se ejecuto el procedimiento con exito");
      logger.info(mensajeLog + "PARAMETROS SP [OUPUT]: ");
      logger.info(mensajeLog + "[PARAMETER_SALIDA]=[" + response.getMensajeError() + Constantes.CORCHETE_DER);

    } catch (Exception e) {
      logger.error(mensajeLog + "ERROR[Exception]:" + e.getMessage(), e);
      throw new DBException("-3","Ha ocurrido un error espeluznante", e);
    } finally {
      tiempoFin = System.currentTimeMillis();
      logger.info(mensajeLog + "Tiempo que demoro en la ejecucion [" + (tiempoFin - tiempoInicio) + " ms]");
      logger.info(mensajeLog + "===Fin    del metodo registrarTransaccion-DAO===");
    }
    return response;
  }
}
