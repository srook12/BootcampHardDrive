package junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
   @Test
   public void testAdd() {
      String str = "JUnit is working fine";
      assertEquals("JUnit is working fine",str);
   }
}
