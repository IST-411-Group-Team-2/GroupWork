package services;

import entities.AuctionItem;
import java.util.ArrayList;
import java.util.List;

public class AuctionItemService {
    private static AuctionItemService instance;
    private static List<AuctionItem> data = new ArrayList<>();
    
    static {
        data.add(new AuctionItem(0, "Sofa", "Tom", "Like New - Blue sofa", 100.00));
        data.add(new AuctionItem(1, "Bike", "Jill", "Gently Used - Adult Bicycle", 35.00));
        data.add(new AuctionItem(2, "Coffee Pot", "Beth", "Brand New - 12 cup coffe maker", 19.99));
        data.add(new AuctionItem(3, "Necklace", "John", "Used - Gold necklace", 229.75));
        data.add(new AuctionItem(4, "TV", "Joe", "Open Box - 55 inch Television", 445.00));
    }

    public static AuctionItemService getInstance() {
        if (instance == null) {
            instance = new AuctionItemService();
        }
        return instance;
    }

    public AuctionItem getAuctionItem(int id) {
        return data.get(id);
    }

    public List<AuctionItem> getAllAuctionItems() {
        return data;
    }
}
