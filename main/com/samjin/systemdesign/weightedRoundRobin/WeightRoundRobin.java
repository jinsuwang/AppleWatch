package com.samjin.systemdesign.weightedRoundRobin;

import java.util.ArrayList;
import java.util.List;

public class WeightRoundRobin {

    private int currentIndex = -1;
    private int currentWeight = 0;
    private int maxWeight = 0;

    // 最大公约数
    private int gcdWeight = 0;

    private int serverCount = 0;

    private List<Server> servers = new ArrayList<Server>();

    private int greaterCommonDivisor(int a, int b){
        if( a % b == 0 ) return b;
        else{
            return greaterCommonDivisor(b, a % b);
        }
    }

    private int greatestCommonDivisor(List<Server> servers){
        int divisor = 0;
        int len = servers.size();

        for(int index = 0; index < len - 1; index++ ){
            if(index == 0){
                divisor = greaterCommonDivisor(
                        servers.get(index).getWeight(),
                        servers.get(index+1).getWeight()
                );
            }else{
                divisor = greaterCommonDivisor(
                        divisor, servers.get(index).getWeight()
                );
            }
        }
        return divisor;
    }

    private int greatestWeight(List<Server> servers){
        int weight = 0;
        for(Server s : servers){
            weight = Math.max(weight, s.getWeight());
        }
        return weight;
    }

    public Server getServer(){
        while(true) {
            currentIndex = (currentIndex + 1) % serverCount;
            if (currentIndex == 0) {
                currentWeight = currentWeight - gcdWeight;
                if (currentWeight <= 0) {
                    currentWeight = maxWeight;
                    if (currentWeight == 0) {
                        return null;
                    }
                }
            }

            System.out.println(String.format("currentIndex: %s, currentWeight: %s", currentIndex, currentWeight));

            if (servers.get(currentIndex).getWeight() >= currentWeight) {
                return servers.get(currentIndex);
            }
        }
    }

    private void init(){
        servers.add(new Server("192.168.191.1", 1));
        servers.add(new Server("192.168.191.2", 2));
        servers.add(new Server("192.168.191.4", 4));
        servers.add(new Server("192.168.191.8", 8));

        maxWeight = greatestWeight(servers);

        gcdWeight = greatestCommonDivisor(servers);
        serverCount = servers.size();

        System.out.println(String.format("MaxWeight: %s, gcdWeight: %s, serverCount: %s", maxWeight, gcdWeight, serverCount));
    }

    public static void main(String[] args) {
        WeightRoundRobin weightRoundRobin = new WeightRoundRobin();

        weightRoundRobin.init();
        for(int i = 0; i < 15; i++){
            Server server = weightRoundRobin.getServer();
            System.out.println("server " + server.getIp() + " weight=" + server.getWeight());
        }
    }
}
