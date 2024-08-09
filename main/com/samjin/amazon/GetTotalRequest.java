package com.samjin.amazon;

public class GetTotalRequest {


    public int[] getTotalRequests(int[] server, int[] replaced, int[] newId) {
        // write your code here

        int n = server.length;
        int m = replaced.length;
        int[] totalRequests = new int[m];

        // Calculate the initial total requests served
        int currentTotalRequests = 0;
        for (int i = 0; i < n; i++) {
            currentTotalRequests += server[i];
        }

        // Process each replacement operation
        for (int j = 0; j < m; j++) {
            int oldId = replaced[j];
            int newIdValue = newId[j];

            // Replace oldId with newIdValue and update the total requests served
            for (int i = 0; i < n; i++) {
                if (server[i] == oldId) {
                    currentTotalRequests -= oldId;      // Remove the old id value
                    currentTotalRequests += newIdValue; // Add the new id value
                    server[i] = newIdValue;             // Update the server id in the array
                }
            }

            // Store the result for the current day
            totalRequests[j] = currentTotalRequests;
        }

        return totalRequests;
    }
}
