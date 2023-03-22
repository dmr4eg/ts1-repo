package hw2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
        //ARRANGE
        static Calculator calc;
        @BeforeAll
        public static void initVariable() {
            Calculator calc = new Calculator();
        }

        @Test
//        @ParametrizedTest
        public void add_addsAtoB_5() {
            //ARRANGE
            Calculator calc = new Calculator();

            //ACT
            int num = calc.add(2, 3);

            //ASSERT
            Assertions.assertEquals(5, num);
        }

        @Test
        public void subtract_substractsAfromB_3() {
            //ARRANGE
            Calculator calc = new Calculator();

            //ACT
            int num = calc.subtract(6, 3);

            //ASSERT
            Assertions.assertEquals(3, num);
        }

        @Test
        public void multiply_multiplyAtoB_10() {
            //ARRANGE
            Calculator calc = new Calculator();

            //ACT
            int num = calc.multiply(5, 2);

            //ASSERT
            Assertions.assertEquals(10, num);
        }

        @Test
        @Order(1)
        public void divide_divisionofAtoB_4() {
            //ARRANGE
            Calculator calc = new Calculator();

            //ACT
            int num = calc.divide(16, 4);

            //ASSERT
            Assertions.assertEquals(4, num);
        }

        @Test
        @Order(2)
        public void divide_divisionofAtoB_N() {
            //ARRANGE
            Calculator calc = new Calculator();

            // ACT + ASSERT 1
            Exception exception = Assertions.assertThrows(Exception.class, () -> calc.divide(16, 0));

            String expectedMessage = "/ by zero";
            String actualMessage = exception.getMessage();

            // ASSERT 2
            Assertions.assertEquals(expectedMessage, actualMessage);
        }

}
