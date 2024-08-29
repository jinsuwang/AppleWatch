package com.samjin.design.ood.coffeemachine;

public interface Coffee {

    public double getCost();
    public String getIngredients();

    // 普通coffee
    public class SimpleCoffee implements Coffee {
        @Override
        public double getCost() {
            return 1;
        }

        @Override
        public String getIngredients () {
            return "Coffee";
        }
    }
}
