package it.pkg.service;

import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.pkg.bean.DataMessageObject;
import it.pkg.bean.RequestRegistrarTransaccionBean;
import it.pkg.dao.DatabaseRepository;
import it.pkg.util.PropertiesExterno;

@Service
public class BasicMdbServiceImpl implements BasicMdbService{
  
  private static Logger      logger = Logger.getLogger( BasicMdbServiceImpl.class );
  @Autowired
  private PropertiesExterno  propertiesExterno;
  @Autowired
  private DatabaseRepository databaseRepository;
  
  @Override
  public void iniciarService( DataMessageObject messageObject, TextMessage textMessage, String trazabilidad ){
    long tiempoInicio = System.currentTimeMillis();
    logger.info( trazabilidad + "[INICIO]-METODO:MESSAGE" );
    try{
      RequestRegistrarTransaccionBean request=null;
      
      databaseRepository.registrarTransaccion( trazabilidad , request );
      
      logger.info( String.format( "%s se ha obtenido codigo de respuesta %s", 
                                  trazabilidad,
                                  propertiesExterno.respuestaCodigoExito ) );
    }
    catch( Exception ex ){
      logger.error( trazabilidad, ex );
    }
    finally{
      logger
          .info( trazabilidad + "Tiempo Transacurrido (ms): [" + ( System.currentTimeMillis() - tiempoInicio ) + "]" );
      logger.info( trazabilidad + "[FIN] - METODO:MESSAGE" );
    }
  }
  
}