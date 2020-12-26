package it.pkg.test.mdb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import it.pkg.mdb.BasicMdb;
import it.pkg.test.conf.BasicMdbTestConfig;
import it.pkg.util.PropertiesExterno;

@ExtendWith(SpringExtension.class) 
@ContextConfiguration(classes = BasicMdbTestConfig.class)
@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
class BasicMdbTest{
  
  static BasicMdb mdb;
 
  @Autowired
  PropertiesExterno propertiesExterno;
  
  @BeforeAll
  static void cargarMdb() {
	  mdb= new BasicMdb();
  }
  
  @Test
  @DisplayName("Simple test")
  void test(){
    assertEquals(2, mdb.getMessage(), "1 + 1 should equal 2");
    
  }
  
  @Test
  @DisplayName("😱")
  void testProperties(){
    assertEquals("pe.dmner.jndi", propertiesExterno.demneruJndi, "propertiesExterno.demneruJndi should equal pe.dmner.jndi");
    
  }
  
  @ParameterizedTest(name = "Year {0} is a leap year.")
  @ValueSource(ints = { 2016, 2020, 2048 })
  void if_it_is_one_of_the_following_years(int year) {
    assertEquals( 0, year%2);
  }

}
