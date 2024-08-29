package com.samjin.design.ood.coffeemachine;

public class CoffeeWithMilk extends CoffeeDecorator {
    public CoffeeWithMilk (Coffee c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.5; // 得到父类的价格，再加上奶的价格
    }

    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }
}