package com.samjin.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorker {
    class Worker{
        int quality;
        int wage;
        public Worker(int q, int w){
            this.quality = q;
            this.wage = w;
        }
        public double getRatio(){
            return (double)wage/quality;
        }

    }
    class Myc implements Comparator<Worker> {
        public Myc(){

        }
        @Override
        public int compare(Worker x, Worker y){
            return Double.compare(x.getRatio(),y.getRatio());
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] worker = new Worker[quality.length];
        for(int i = 0; i < quality.length; i++){
            worker[i] = new Worker(quality[i], wage[i]);
        }
        int sumQuality = 0;
        double ans = Double.MAX_VALUE;
        Myc myc = new Myc();
        Arrays.sort(worker,myc);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->y-x);
        for(Worker w : worker){
            //System.out.println(w.quality+" "+ w.getRatio());
            pq.offer(w.quality);
            sumQuality += w.quality;
            if(pq.size()>K){
                //remove the largest quality
                sumQuality-=pq.poll();
            }
            //if we have k person now, update answer
            if(pq.size()==K){
                ans = Math.min(ans,sumQuality*w.getRatio());
            }
        }
        return ans;
    }
}
