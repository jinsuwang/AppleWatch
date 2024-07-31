package com.samjin.design.ood.singleton;

/**
 * Created by sjjin on 6/11/17.
 */
public class Singleton {

    /*
     Volatile keyword ensures that multiple threads
     handle the uniqueInstance variable correctly when
     it being initialize to the Singleton instance.
     volatile keyword ensure variable is disabled by L1 cache
     and in the main memory and can be accessed by multiple thread.
    */
    private volatile static Singleton uniqueInstance;

    private Singleton(){
        // put your logic here.
    }

    public static Singleton getInstance(){
        // check for an instance and if there isn't one.
        // enter a synchronized blocked. We only synchronize the first time.
        if( uniqueInstance == null ){
            synchronized ( Singleton.class ){
                // check again.
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
