package shopTest;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import shop.Orders;
import shop.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class OrdersTest {  //done
    @Order(1)
    @Test   // if all parameters are passed, the test passes
    void OrderTest_order() {
        Orders order = new Orders(new ShoppingCart(), "name", "address", 1);
        assertEquals("name", order.getCustomerName());
        assertEquals("address", order.getCustomerAddress());
        assertEquals(1, order.getState());
    }

    @Order(2)
    @Test   // if state is not passed as a parameter, the test fails
    void OrderTest_order_0(){
        Orders order = new Orders(new ShoppingCart(), "name", "address");
        assertEquals("name", order.getCustomerName());
        assertEquals("address", order.getCustomerAddress());
        assertEquals(0, order.getState());
    }

    @Order(3)
    @Test   // if null is passed as a parameter, the test fails
    void OrderTest_order_null_name(){
        Orders order = new Orders(new ShoppingCart(), null, "address");
        assertEquals(null, order.getCustomerName());
        assertEquals("address", order.getCustomerAddress());
        assertEquals(0, order.getState());
    }

    @Order(4)
    @Test   // if null is passed as a parameter, the test fails
    void OrderTest_order_null_address(){
        Orders order = new Orders(new ShoppingCart(), "name", null);
        assertEquals("name", order.getCustomerName());
        assertEquals(null, order.getCustomerAddress());
        assertEquals(0, order.getState());
    }

    @Order(5)
    @Test   // if null is passed as a parameter, the test fails
    void OrderTest_order_nulls(){
        Orders order = new Orders(new ShoppingCart(), null, null);
        assertEquals(null, order.getCustomerName());
        assertEquals(null, order.getCustomerAddress());
        assertEquals(0, order.getState());
    }
}
