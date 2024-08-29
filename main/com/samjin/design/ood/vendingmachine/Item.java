package com.samjin.design.ood.vendingmachine;

public class Item {

    private ItemInfo info;

    public Item(ItemInfo info) {
        this.info = info;
    }

    public ItemInfo getInfo() {
        return info;
    }
}
