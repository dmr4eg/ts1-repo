package cz.cvut.fel.ts1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FooTest {

    //ARRANGE
    static Foo f;

    @BeforeAll
    public static void initVariable() {
        f = new Foo();
    }

    @Test
    public void returnNumber_returnsNumber_5() {
        //ARRANGE
        Foo foo = new Foo();

        //ACT
        int num = foo.returnNumber();

        //ASSERT
        Assertions.assertEquals(5, num);
    }

    @Test
    @Order(1)
    public void increment_incrementsByOne_returns1() {
        //ACT
        f.increment();

        //ASSERT
        Assertions.assertEquals(1, f.getNum());
    }

    @Test
    @Order(2)
    public void increment_incrementsByOne_returns2() {
        //ACT
        f.increment();

        //ASSERT
        Assertions.assertEquals(2, f.getNum());
    }

    @Test
    public void exceptionThrownTest_exceptionThrown_exception() {
        //ARRANGE
        Foo foo = new Foo();

        // ACT + ASSERT 1 (Obsahuje assert, zda byla vyhozena výjimka očekávaného typu)
        Exception exception = Assertions.assertThrows(Exception.class, () -> f.exceptionThrown());

//        Exception exception = Assertions.assertThrows(Exception.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                foo.exceptionThrown();
//            }
//        });
        String expectedMessage = "Ocekavana vyjimka";
        String actualMessage = exception.getMessage();

        // ASSERT 2
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
