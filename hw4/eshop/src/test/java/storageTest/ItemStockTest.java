package storageTest;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.Item;
import storage.ItemStock;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class ItemStockTest {
    @Test
    @Order(1)
    void ItemStockTest() {
        Item item = new Item(1, "name", 1, "category") {
            @Override
            public String toString() {
                return null;
            }
        };
    }

    @Test
    @Order(2)
    void ItemStockTest2() {
        Item item = new Item(1, "name", 1, "category") {
            @Override
            public String toString() {
                return null;
            }
        };
        ItemStock itemStock = new ItemStock(item);
        assertEquals(0, itemStock.getCount());
    }


    @ParameterizedTest
    @CsvSource({"1, name, 1, category",
            "2, name2, 2, category2",
            "3, name3, 3, category3",
            "4, name4, 4, category4",
            "5, name5, 5, category5"})
    void IncreaseItemCountTest(int id, String name, float price, String category) {
        Item item = new Item(id, name, price, category) {
            @Override
            public String toString() {
                return null;
            }
        };
        ItemStock itemStock = new ItemStock(item);
        itemStock.IncreaseItemCount(1);
        assertEquals(1, itemStock.getCount());
    }


}
