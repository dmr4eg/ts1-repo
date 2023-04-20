package shopTest;

import archive.PurchasesArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.*;
import storage.NoItemInStorage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import static shop.EShopController.newCart;
import static shop.EShopController.purchaseShoppingCart;



public class EShopControllerTest { // done
    ShoppingCart shoppingCart;
    ByteArrayOutputStream myOut;
    Item[] storageItems;

    @BeforeEach
    public void setupEshop(){
        //ARRANGE
        EShopController.storage = null;
        EShopController.startEShop();

        shoppingCart = newCart();

        storageItems = new Item[]{
                new StandardItem(1, "Item1", 2000, "Something", 10),
                new StandardItem(2, "Item2", 3000, "Something", 20),
                new StandardItem(3, "Item3", 1200, "Something", 10),
                new DiscountedItem(4, "Item4", 600, "Something", 50, "1.8.2023", "1.12.2023"),
                new DiscountedItem(5, "Item5", 4000, "Something", 5, "1.9.2023", "1.12.2023"),
                new DiscountedItem(6, "Item6", 900, "Something", 20, "1.8.2023", "1.12.2023")
        };

        // insert data to the storage
        int[] itemCount = {10,10,4,5,10,1};
        for (int i = 0; i < storageItems.length; i++) {
            EShopController.storage.insertItems(storageItems[i], itemCount[i]);
        }

        myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void purchaseEmptyShoppingCart_Test(){
        //ACT
        try {
            EShopController.purchaseShoppingCart(shoppingCart, "Hurvinek Hurvinek", "YesNo");
        } catch (NoItemInStorage e) {
            e.printStackTrace();
        }
        String result = myOut.toString().trim();

        //ASSERT
        Assertions.assertEquals("Error: shopping cart is empty", result);
    }

    @Test
    public void BuyingOutOfStockItem_Test(){
        //ARRANGE
        String expectedResult = "STORAGE IS CURRENTLY CONTAINING:\n" +
                "1. Item1, 2000, Something, 10\n" +
                "2. Item2, 3000, Something, 20\n" +
                "3. Item3, 1200, Something, 10\n" +
                "4. Item4, 600, Something, 50\n" +
                "5. Item5, 4000, Something, 5\n" +
                "6. Item6, 900, Something, 20\n" +
                "Error: item is out of stock";
        Item item6 = storageItems[5];

        //ACT
        EShopController.storage.printListOfStoredItems();
        shoppingCart.addItem(storageItems[0]);
        shoppingCart.removeItem(5);

        shoppingCart.addItem(storageItems[5]);

        //ASSERT
        //STRING PRINTS
        String result = myOut.toString().trim();
        Assertions.assertEquals(expectedResult, result);

        //EXCEPTION THROW
        Assertions.assertThrows(NoItemInStorage.class, () -> {purchaseShoppingCart(shoppingCart, "Bruh No", "What is this");});

        //STOCK
        int itemStock = EShopController.storage.getItemCount(6);

        Assertions.assertEquals(0, itemStock);

        //SALES
        int itemSold6 = PurchasesArchive.getHowManyTimesHasBeenItemSold(item6);
        Assertions.assertEquals(0, itemSold6);
    }

    @Test
    public void standardExperience_Test(){
        //ARRANGE
        Item item4 = storageItems[3];
        Item item5 = storageItems[4];

        String printListOfStoreItems = "STORAGE IS CURRENTLY CONTAINING:\n" +
                "1. Item1, 2000, Something, 10\n" +
                "2. Item2, 3000, Something, 20\n" +
                "3. Item3, 1200, Something, 10\n" +
                "4. Item4, 600, Something, 50\n" +
                "5. Item5, 4000, Something, 5\n";

        String addItem = "Item1, 2000, Something, 10\n" +
                "Item4, 600, Something, 50\n" +
                "Item5, 4000, Something, 5\n";
        String addItem2 = "Item4, 600, Something, 50\n" +
                "Item5, 4000, Something, 5\n";
        String printItemPurchaseStatistics = "Item1, 2000, Something, 10\n" +
                "Item4, 600, Something, 50\n" +
                "Item5, 4000, Something, 5\n";
        String printListOfStoreItems2 = "STORAGE IS CURRENTLY CONTAINING:\n" +
                "1. Item1, 2000, Something, 9\n" +
                "2. Item2, 3000, Something, 20\n" +
                "3. Item3, 1200, Something, 10\n" +
                "4. Item4, 600, Something, 49\n" +
                "5. Item5, 4000, Something, 4\n" +
                "6. Item6, 900, Something, 20\n";

        String expectedResult = printListOfStoreItems + addItem + addItem2 + printItemPurchaseStatistics + printListOfStoreItems2;

        //ACT
        EShopController.storage.printListOfStoredItems();
        shoppingCart.addItem(storageItems[2]);
        shoppingCart.removeItem(5);

        shoppingCart.addItem(item5);

        try {
            EShopController.purchaseShoppingCart(shoppingCart, "Robert Bateman", "CVUT FEL");
        } catch (NoItemInStorage e) {
            e.printStackTrace();
        }
        PurchasesArchive.printItemPurchaseStatistics();
        EShopController.storage.printListOfStoredItems();

        //ASSERT
        //PRINT MESSAGES
        String result = myOut.toString().trim();
        Assertions.assertEquals(expectedResult, result);

        //STORAGE STOCK
        int itemStock4 = EShopController.storage.getItemCount(4);
        int itemStock5 = EShopController.storage.getItemCount(5);
        Assertions.assertEquals(4, itemStock4);
        Assertions.assertEquals(9, itemStock5);

        //ARCHIVE
        int itemSold4 = PurchasesArchive.getHowManyTimesHasBeenItemSold(item4);
        int itemSold5 = PurchasesArchive.getHowManyTimesHasBeenItemSold(item5);
        Assertions.assertEquals(1, itemSold4);
        Assertions.assertEquals(1, itemSold5);
    }
}