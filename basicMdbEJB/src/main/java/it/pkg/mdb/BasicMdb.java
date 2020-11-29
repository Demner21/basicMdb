package it.pkg.mdb;

import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import it.pkg.bean.DataMessageObject;
import it.pkg.service.BasicMdbService;
import it.pkg.util.Constantes;
import it.pkg.util.JAXBUtilitarios;
import it.pkg.util.SpringBeanInterceptors;

@MessageDriven
@Interceptors( SpringBeanInterceptors.class )
public class BasicMdb implements MessageListener{
  
  private static Logger   logger = Logger.getLogger( BasicMdb.class );
  
  @Autowired
  private BasicMdbService service;
  
  public void onMessage( Message message ){
    final long vTiempoProceso = System.currentTimeMillis();
    String msjTx = null;
    try{
      String messageID = message.getJMSMessageID();
      msjTx = "[onMessage][messageID=" + messageID + "] ";
      logger.info( msjTx + Constantes.SEPARADOR_GUIONES );
      logger.info( msjTx + "[INICIO] - METODO: [onMessage]" );
      logger.info( msjTx + Constantes.SEPARADOR_GUIONES );
      logger.info( msjTx + "Leer mensaje de la cola" );
      String mensaje = "";
      
      if( !( message instanceof TextMessage ) ){
        logger.info( msjTx + "Tipo de mensaje diferente al soportado." );
        throw new JMSException( "Tipo de mensaje diferente al soportado" );
      }
      
      logger.info( msjTx + "Tipo de mensaje: [TextMessage]" );
      TextMessage textMessage = (TextMessage)message;
      logger.info( msjTx + "OBJETO [INPUT]: " + textMessage.getText() );
      
      DataMessageObject dataMessage = (DataMessageObject)JAXBUtilitarios
          .xmlTextToJaxB( textMessage.getText(), DataMessageObject.class );
      
      if( dataMessage == null ){
        logger.info( msjTx + "Estructura de mensaje no sorportado." );
        throw new JMSException( "Estructura de mensaje no sorportado." );
      }
      
      
      mensaje = "[txId=" + dataMessage.getIdTransaccion() + "]";
      service.iniciarService( dataMessage, textMessage, mensaje );
    }
    catch( Exception e ){
      logger.error( msjTx + "Error: " + e.getMessage(), e );
    }
    finally{
      logger.info( msjTx + "Tiempo total de proceso(ms): " + ( System.currentTimeMillis() - vTiempoProceso )
          + " milisegundos." );
      logger.info( msjTx + Constantes.SEPARADOR_GUIONES );
      logger.info( msjTx + "[FIN] - METODO: [onMessage]" );
      logger.info( msjTx + Constantes.SEPARADOR_GUIONES );
    }
  }

  public Integer getMessage(){
    return 2;
  }
}