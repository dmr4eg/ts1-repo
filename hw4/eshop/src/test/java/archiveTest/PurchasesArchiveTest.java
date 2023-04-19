package archiveTest;

import archive.ItemPurchaseArchiveEntry;
import archive.PurchasesArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import shop.Item;
import shop.Orders;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import static org.mockito.Mockito.*;

public class PurchasesArchiveTest { // done
    @Test
    public void printItemPurchaseStatisticsTest_isEmpty(){
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        PurchasesArchive purchasesArchive = new PurchasesArchive();
        PurchasesArchive.printItemPurchaseStatistics();
        String result = myOut.toString().trim();

        Assertions.assertEquals("ITEM PURCHASE STATISTICS:", result);

        System.setOut(System.out);
    }

    @Test
    public void printItemPurchaseStatisticsTest_isFilled(){
        //ARRANGE
        //PREPARE OUT STREAM
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        //MOCK AND CONSTRUCT
        ItemPurchaseArchiveEntry mockedEntry = mock(ItemPurchaseArchiveEntry.class);
        when(mockedEntry.toString()).thenReturn("a");
        HashMap<Integer, ItemPurchaseArchiveEntry> hashMap = new HashMap<Integer, ItemPurchaseArchiveEntry>();
        hashMap.put(1, mockedEntry);
        ArrayList<Orders> mockedOrders = mock(ArrayList.class);
        PurchasesArchive archive = new PurchasesArchive(hashMap, mockedOrders);

        //ACT
        archive.printItemPurchaseStatistics();
        String expectedResult = "ITEM PURCHASE STATISTICS:\na";
        String result = myOut.toString().trim();

        //ASSERT
        Assertions.assertEquals(expectedResult, result);

        //CLEANUP
        System.setOut(System.out);
    }

    @Test
    public void getHowManyTimesHasBeenItemSold_mockedTest(){
        //ARRANGE
        //PREPARE OUT STREAM
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        //MOCK AND CONSTRUCT
        Item mockedItem = mock(Item.class);
        ItemPurchaseArchiveEntry mockedPurchaseEntry = mock(ItemPurchaseArchiveEntry.class);
        HashMap<Integer, ItemPurchaseArchiveEntry> mockedItemArchive = mock(HashMap.class);
        when(mockedItemArchive.containsKey(anyInt())).thenReturn(true);
        when(mockedItemArchive.get(anyInt())).thenReturn(mockedPurchaseEntry);
        ArrayList<Orders> mockedOrders = mock(ArrayList.class);
        PurchasesArchive archive = new PurchasesArchive(mockedItemArchive, mockedOrders);

        //ACT
        archive.getHowManyTimesHasBeenItemSold(mockedItem);

        //ASSERT
        verify(mockedPurchaseEntry, times(1)).getCountHowManyTimesHasBeenSold();

        //CLEANUP
        System.setOut(System.out);
    }

    @Test
    public void itemPurchaseArchiveEntry_test(){
        Item mockedItem = mock(Item.class);
        ItemPurchaseArchiveEntry entry = new ItemPurchaseArchiveEntry(mockedItem);

        Assertions.assertEquals(mockedItem, entry.getRefItem());
    }
}
