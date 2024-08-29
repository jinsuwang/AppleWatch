package com.samjin.design.ood.vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private Map<ItemInfo, List<Item>> stock = new HashMap<>();

    public int getQuantity(ItemInfo info) {
        return stock.getOrDefault(info, new ArrayList<>()).size();
    }

    public void add(Item t) {
        stock.computeIfAbsent(t.getInfo(), k -> new ArrayList<>()).add(t);
    }

    public void deduct(ItemInfo info) throws NotEnoughItemException {
        List<Item> items = stock.get(info);
        if (items == null || items.isEmpty()) {
            throw new NotEnoughItemException();
        }
        items.remove(items.size() - 1);
    }
}
