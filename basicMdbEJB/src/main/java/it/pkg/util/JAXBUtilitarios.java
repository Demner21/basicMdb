package it.pkg.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAXBUtilitarios{
  
  private static final Logger                wlLogger    = LoggerFactory.getLogger( JAXBUtilitarios.class.getName() );
  private static HashMap<Class, JAXBContext> mapContexts = new HashMap<Class, JAXBContext>();
  
  private static JAXBContext obtainJaxBContextFromClass( Class clas ){
    JAXBContext context;
    context = mapContexts.get( clas );
    if( context == null ){
      try{
        wlLogger.info( "Inicializando jaxcontext... para la clase " + clas.getName() );
        context = JAXBContext.newInstance( clas );
        mapContexts.put( clas, context );
      }
      catch( Exception e ){
        wlLogger.error( "Error creando JAXBContext:", e );
      }
    }
    return context;
  }
  
  public String getXmlTextFromJaxB( Object objJaxB ){
    String commandoRequestEnXml = null;
    JAXBContext context;
    try{
      context = obtainJaxBContextFromClass( objJaxB.getClass() );
      Marshaller marshaller = context.createMarshaller();
      StringWriter xmlWriter = new StringWriter();
      marshaller.marshal( objJaxB, xmlWriter );
      XmlObject xmlObj = XmlObject.Factory.parse( xmlWriter.toString() );
      commandoRequestEnXml = xmlObj.toString();
    }
    catch( Exception e ){
      wlLogger.error( "Error parseando object to xml:", e );
    }
    return commandoRequestEnXml;
  }
  
  public static String anyObjectToXmlText( Object objJaxB ){
    String commandoRequestEnXml = null;
    JAXBContext context;
    try{
      if( objJaxB != null ){
        context = obtainJaxBContextFromClass( objJaxB.getClass() );
        Marshaller marshaller = context.createMarshaller();
        StringWriter xmlWriter = new StringWriter();
        marshaller.marshal(
            new JAXBElement( new QName( "", objJaxB.getClass().getName() ), objJaxB.getClass(), objJaxB ), xmlWriter );
        XmlObject xmlObj = XmlObject.Factory.parse( xmlWriter.toString() );
        commandoRequestEnXml = xmlObj.toString();
      }
    }
    catch( Exception e ){
      wlLogger.error( "Error parseando object to xml:", e );
    }
    return commandoRequestEnXml;
  }
  
  public static Object xmlTextToJaxB( String xmlText, Class clas ){
    JAXBContext context;
    Object object = null;
    try{
      context = obtainJaxBContextFromClass( clas );
      Unmarshaller um = context.createUnmarshaller();
      InputStream is = new ByteArrayInputStream( xmlText.getBytes( "UTF-8" ) );
      object = um.unmarshal( is );
    }
    catch( Exception e ){
      wlLogger.error( "Error unmarshalling xmlObject:" + xmlText + ". Detalle Error:", e );
    }
    return object;
  }
}
