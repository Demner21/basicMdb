package it.pkg.mdb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
class BasicMdbTest{
  
  BasicMdb mdb;
  
  @Test
  @DisplayName("😱")
  void test(){
    
    mdb= new BasicMdb();
    assertEquals(2, mdb.getMessage(), "1 + 1 should equal 2");
    
  }
  

  @ParameterizedTest(name = "Year {0} is a leap year.")
  @ValueSource(ints = { 2016, 2020, 2048 })
  void if_it_is_one_of_the_following_years(int year) {
    assertEquals( 0, year%2);
  }

}
