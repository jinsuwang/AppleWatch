package com.samjin.design.ood.coffeemachine;

public class CoffeeWithSprinkles extends CoffeeDecorator {
    public CoffeeWithSprinkles (Coffee c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Sprinkles";
    }
}