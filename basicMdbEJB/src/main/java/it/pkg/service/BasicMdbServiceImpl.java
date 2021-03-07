package it.pkg.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pkg.bean.DataMessageObject;
import it.pkg.bean.RequestRegistrarTransaccionBean;
import it.pkg.bean.ResponseRegistrarTransaccionBean;
import it.pkg.dao.DatabaseRepository;
import it.pkg.util.PropertiesExterno;

@Service
public class BasicMdbServiceImpl implements BasicMdbService {

  private static Logger logger = Logger.getLogger(BasicMdbServiceImpl.class);
  private PropertiesExterno propertiesExterno;
  private DatabaseRepository databaseRepository;

  @Autowired
  public BasicMdbServiceImpl(PropertiesExterno propertiesExterno, DatabaseRepository databaseRepository) {
    super();
    this.propertiesExterno = propertiesExterno;
    this.databaseRepository = databaseRepository;
  }

  @Override
  public String iniciarService(DataMessageObject messageObject, String trazabilidad) {
    long tiempoInicio = System.currentTimeMillis();
    logger.info(trazabilidad + "[INICIO]-METODO:MESSAGE");
    ResponseRegistrarTransaccionBean registrarTransaccion = null;
    try {
      RequestRegistrarTransaccionBean request = new RequestRegistrarTransaccionBean();

      registrarTransaccion = databaseRepository.registrarTransaccion(trazabilidad, request);
      
        logger.info(String.format("%s se ha obtenido codigo de respuesta %s", trazabilidad,
            registrarTransaccion !=null ? registrarTransaccion.getCodigoError() :propertiesExterno.respuestaCodigoError));

    } catch (Exception ex) {
      logger.error(trazabilidad, ex);
    } finally {
      logger.info(trazabilidad + "Tiempo Transacurrido (ms): [" + (System.currentTimeMillis() - tiempoInicio) + "]");
      logger.info(trazabilidad + "[FIN] - METODO:MESSAGE");
    }
    return registrarTransaccion != null ? registrarTransaccion.getCodigoError() : propertiesExterno.respuestaCodigoError;
  }

}