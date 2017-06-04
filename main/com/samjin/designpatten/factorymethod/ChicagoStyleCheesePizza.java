package com.samjin.designpatten.factorymethod;

/**
 * Created by sjjin on 6/1/17.
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Deep Dish Cheese pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sause";

        toppings.add("Shredded Mozarella Cheese");
    }

    void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
