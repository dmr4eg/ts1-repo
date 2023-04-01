package shopTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import shop.StandardItem;

import static org.junit.jupiter.api.Assertions.*;

class StandardItemTest { // every test is done
    @Test
    void StandardItemTest_item() {
        StandardItem item = new StandardItem(1, "name", 1, "category", 1);
        assertEquals(1, item.getID());
        assertEquals("name", item.getName());
        assertEquals(1, item.getPrice());
        assertEquals("category", item.getCategory());
        assertEquals(1, item.getLoyaltyPoints());
    }
    @Test
    void copyTest_item() {
        StandardItem item = new StandardItem(1, "name", 1, "category", 1);
        StandardItem copy = item.copy();
        assertEquals(item.getName(), copy.getName());
        assertEquals(item.getCategory(), copy.getCategory());
        assertEquals(item.getID(), copy.getID());
        assertEquals(item.getPrice(), copy.getPrice());
        assertEquals(item.getLoyaltyPoints(), copy.getLoyaltyPoints());
    }
    @ParameterizedTest
    @CsvSource({
            "1, name, 1, category, 1",
            "2, name2, 2, category2, 2",
            "3, name3, 3, category3, 3",
            "4, name4, 4, category4, 4",
            "5, name5, 5, category5, 5"})
    void equalsTest_item(int id, String name, float price, String category, int loyaltyPoints) {
        StandardItem item = new StandardItem(id, name, price, category, loyaltyPoints);
        StandardItem item2 = new StandardItem(id, name, price, category, loyaltyPoints);
        assertTrue(item.equals(item2));
    }
}
