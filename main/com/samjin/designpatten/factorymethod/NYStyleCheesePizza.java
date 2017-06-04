package com.samjin.designpatten.factorymethod;

/**
 * Created by sjjin on 6/1/17.
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza(){
        name = "NY Style Sause and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Matinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
