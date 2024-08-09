package com.samjin.amazon;

import java.util.PriorityQueue;

public class BringServersDown {

    static class Server {
        int requestCapacity;
        int health;
        int timeToGoDown;

        Server(int requestCapacity, int health, int k) {
            this.requestCapacity = requestCapacity;
            this.health = health;
            this.timeToGoDown = (int) Math.ceil((double) health / k);
        }
    }

    public int minimumRequests(int[] request, int[] health, int k) {
        int n = request.length;
        int totalRequests = 0;

        // Max-heap to process servers with the maximum requests first
        PriorityQueue<Server> maxHeap = new PriorityQueue<>((a, b) -> b.requestCapacity - a.requestCapacity);

        for (int i = 0; i < n; i++) {
            maxHeap.add(new Server(request[i], health[i], k));
        }

        while (!maxHeap.isEmpty()) {
            Server server = maxHeap.poll();

            int requestsSent = server.requestCapacity * server.timeToGoDown;
            totalRequests += requestsSent;

            while (!maxHeap.isEmpty()) {
                Server nextServer = maxHeap.poll();
                nextServer.health -= k * server.timeToGoDown;

                if (nextServer.health > 0) {
                    nextServer.timeToGoDown = (int) Math.ceil((double) nextServer.health / k);
                    maxHeap.add(nextServer);
                }
            }
        }

        // One additional request to conclude the failure
        return totalRequests + 1;
    }
}
