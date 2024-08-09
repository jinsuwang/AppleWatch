package com.samjin.amazon;

import java.util.PriorityQueue;

public class GetServerId {

    static class Server {
        int load;
        int index;

        public Server(int load, int index) {
            this.load = load;
            this.index = index;
        }
    }

    public static int[] getServerIds(int num_servers, int[] requests) {
        PriorityQueue<Server> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.load == b.load) {
                return a.index - b.index;
            }
            return a.load - b.load;
        });

        // Initialize the heap with all servers having load 0
        for (int i = 0; i < num_servers; i++) {
            minHeap.offer(new Server(0, i));
        }

        int[] result = new int[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int maxServerIndex = requests[i];
            Server bestServer = null;

//            // Extract servers from the heap until we find one within the allowed range
//            while (!minHeap.isEmpty() && minHeap.peek().index > maxServerIndex) {
//                minHeap.offer(minHeap.poll());
//            }

            bestServer = minHeap.poll();
            result[i] = bestServer.index;

            // Increase the load of the selected server and push it back into the heap
            bestServer.load++;
            minHeap.offer(bestServer);
        }

        return result;
    }

    public static void main(String[] args) {
        int num_servers = 5;
        int[] requests = {4, 0, 2, 2};
        int[] result = getServerIds(num_servers, requests);

        for (int serverId : result) {
            System.out.print(serverId + " ");
        }
    }
}
