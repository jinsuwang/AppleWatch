package com.samjin.array;

public class AverageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        double totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];

            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            currentTime += cookingTime;
            totalWaitingTime += (currentTime - arrivalTime);
        }

        return totalWaitingTime / customers.length;
    }
}
