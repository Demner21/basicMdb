package it.pkg.test.mdb;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.pkg.dao.DatabaseRepository;
import it.pkg.mdb.BasicMdb;
import it.pkg.service.BasicMdbService;
import it.pkg.service.BasicMdbServiceImpl;
import it.pkg.test.conf.BasicMdbTestConfig;
import it.pkg.util.PropertiesExterno;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicMdbTestConfig.class)
public class BasicMdbTest {

  static BasicMdb mdb;
  static BasicMdbService service;

  DatabaseRepository repository;

  @Autowired
  PropertiesExterno propertiesExterno;

  @Before
  public void cargarMdb() {
    service = new BasicMdbServiceImpl(propertiesExterno, repository);
    mdb = new BasicMdb(service);
  }

  @Test
  public void test() {
    assertEquals("2", mdb.getMessage().toString());

  }

  @Test
  public void testProperties() {
    assertEquals("pe.dmner.jndi", propertiesExterno.demneruJndi);
  }

}
