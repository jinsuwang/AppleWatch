package com.samjin.designpatten.factorymethod;

/**
 * Created by sjjin on 6/1/17.
 */
public class ChicagoPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String item) {
        if( item.equals("cheese") ){
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
