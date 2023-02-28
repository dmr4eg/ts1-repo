package cz.cvut.fel.ts1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssyldamTest {
    @Test
    public void factorialTest() {
        Assyldam assyldam = new Assyldam();
        int num = 3;
        long expectedresult = 6;

        long result = assyldam.factorial(num);

        Assertions.assertEquals(expectedresult, result);
    }
}
