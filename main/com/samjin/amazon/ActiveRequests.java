package com.samjin.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActiveRequests {

    public static List<Integer> countActiveRequests(int requests, int[] wait_time) {
        List<Integer> activeRequestsPerSecond = new ArrayList<>();
        List<Integer> requestList = new ArrayList<>();

        // Initialize request list with wait times
        for (int time : wait_time) {
            requestList.add(time);
        }

        int currentTime = 0;

        while (!requestList.isEmpty()) {
            // Remove the request at index 0
            requestList.remove(0);
            currentTime++;

            // Remove all requests that exceeded their wait time
            Iterator<Integer> iterator = requestList.iterator();
            while (iterator.hasNext()) {
                int remainingTime = iterator.next();
                if (remainingTime <= currentTime) {
                    iterator.remove();
                }
            }

            // Add the number of remaining active requests to the result
            activeRequestsPerSecond.add(requestList.size());
        }

        return activeRequestsPerSecond;
    }
}
