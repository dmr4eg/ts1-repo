package archive;

import shop.Item;

public class ItemPurchaseArchiveEntry {
    private Item refItem;
    private int soldCount;
    
    public ItemPurchaseArchiveEntry(Item refItem) {
        this.refItem = refItem;
        soldCount = 1;
    }
    
    void increaseCountHowManyTimesHasBeenSold(int x) {
        soldCount += x;
    }
    
    public int getCountHowManyTimesHasBeenSold() {
        return soldCount;
    }
    
    public Item getRefItem() {
        return refItem;
    }
    
    @Override
    public String toString() {
        return "ITEM  "+refItem.toString()+"   HAS BEEN SOLD "+soldCount+" TIMES";
    }
}
