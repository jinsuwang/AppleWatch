package com.samjin.design.ood.coffeemachine;

public class Main {

    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredients());
    }

    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();

        c = new CoffeeWithMilk(c);

        c = new CoffeeWithSprinkles(c);
    }
}
