package com.samjin.design.ood.vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private List<Coin> coins = new ArrayList<>();

    private Map<String, ItemInfo> itemIdentifiers = new HashMap<>();

    private ItemInfo currentSelection;
    private Map<ItemInfo, List<Item>> items = new HashMap<>();

    private List<Coin> currentCoins = new ArrayList<>();

    private Stock stock;

    public VendingMachine() {
        this.stock = new Stock();
    }

    public float selectItem(String selection) throws NotEnoughItemException {
        currentSelection = itemIdentifiers.get(selection);
        if (currentSelection == null || stock.getQuantity(currentSelection) == 0) {
            throw new NotEnoughItemException();
        }
        return currentSelection.getPrice();
    }

    public void insertCoins(List<Coin> coins) {
        currentCoins.addAll(coins);
    }

    public Pair<Item, List<Coin>> executeTransaction() throws NotEnoughMoneyException, NotEnoughItemException {
        int totalValue = currentCoins.stream().mapToInt(Coin::getValue).sum();
        if (totalValue < currentSelection.getPrice()) {
            throw new NotEnoughMoneyException();
        }

        stock.deduct(currentSelection);
        List<Coin> change = calculateChange(totalValue - (int) currentSelection.getPrice());
        Item item = new Item(currentSelection);
        currentCoins.clear();
        currentSelection = null;

        return new Pair<>(item, change);
    }

    public List<Coin> cancelTransaction() {
        List<Coin> refund = new ArrayList<>(currentCoins);
        currentCoins.clear();
        currentSelection = null;
        return refund;
    }

    public List<Coin> refund() {
        return cancelTransaction();
    }
    public void refillItems(List<Item> items) {
        for (Item item : items) {
            stock.add(item);
        }
    }


    private List<Coin> calculateChange(int amount) {
        List<Coin> change = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            while (amount >= coin.getValue()) {
                change.add(coin);
                amount -= coin.getValue();
            }
        }
        return change;
    }

}
