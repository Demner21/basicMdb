package it.pkg.test.mdb.sin.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import it.pkg.bean.DataMessageObject;
import it.pkg.bean.RequestRegistrarTransaccionBean;
import it.pkg.bean.ResponseRegistrarTransaccionBean;
import it.pkg.dao.DatabaseRepositoryImpl;
import it.pkg.exception.DBException;
import it.pkg.exception.TimeOutException;
import it.pkg.service.BasicMdbServiceImpl;
import it.pkg.util.PropertiesExterno;

@RunWith(MockitoJUnitRunner.class)
public class TestPropertiesSinSpring {
  @InjectMocks
  BasicMdbServiceImpl service;

  @Mock
  PropertiesExterno propertiesExterno;

  @Mock
  DatabaseRepositoryImpl repository;

//  @Before
//  public void cargarMdb() {
//    service = new BasicMdbServiceImpl(propertiesExterno, repository);
//  }

//  @Before
//  public void loadProperties() throws IOException {
//    Properties configProps = new Properties();
//    InputStream iStream = new ClassPathResource("test.properties").getInputStream();
//    configProps.load(iStream);
//  }

  @Test
  public void isJunitWorking() {
    assertTrue(true);
  }

  @Test
  public void testService() throws DBException, TimeOutException {
    DataMessageObject messageObject = new DataMessageObject();
    String trazabilidad = "123";
    ResponseRegistrarTransaccionBean responseMock = new ResponseRegistrarTransaccionBean();
    responseMock.setCodigoError("1");

    when(repository.registrarTransaccion(any(String.class), any(RequestRegistrarTransaccionBean.class)))
        .thenReturn(responseMock);

    String iniciarService = service.iniciarService(messageObject, trazabilidad);

    assertEquals("1", iniciarService);
  }

}
