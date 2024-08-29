package com.samjin.design.ood.pizzafactory;

/**
 * Created by sjjin on 6/1/17.
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {

        if(item.equals("cheese")){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
