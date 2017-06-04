package com.samjin.designpatten.factorymethod;

/**
 * Created by sjjin on 6/1/17.
 */
public abstract class PizzaStore {

    Pizza pizza;

    public Pizza orderPizza(String type){
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
