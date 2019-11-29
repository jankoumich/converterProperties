import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEscaper {


  @Test
  void TestEscapeHTML() {
    Map testSuit = new HashMap<String, String>();

    testSuit.put("cześć", "cze&#347;&#263;");

    testSuit.forEach(
        (key, value) -> {
          String output = Escaper.escapeHTML((String) key);
          assertEquals(value, output);
        }

    );
  }
}