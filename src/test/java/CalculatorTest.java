import jdk.jfr.internal.tool.Main;
import org.junit.jupiter.api.Test;
import ru.ac.uniyar.mf.vl.Rational;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void addition() {
        Rational r1 = new Rational("1", "2");
        Rational r2 = new Rational("2", "3");
        assertEquals(new Rational("7", "6"), r1.add(r2));

    }
}
