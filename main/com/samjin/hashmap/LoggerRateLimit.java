package com.samjin.hashmap;

import java.util.HashMap;

public class LoggerRateLimit {

    private HashMap<String, Integer> messageTimestampMap;

    /** Initialize your data structure here. */
    public LoggerRateLimit() {
        messageTimestampMap = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // If the message is not in the map or the time difference is greater than or equal to 10 seconds
        if (!messageTimestampMap.containsKey(message) || timestamp - messageTimestampMap.get(message) >= 10) {
            // Update the timestamp in the map
            messageTimestampMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
