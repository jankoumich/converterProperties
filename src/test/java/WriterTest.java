import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
  @Test
  void ConstructorTest() {
    Writer output = new Writer("/test");

    assertNotNull(output);
  }
}