package com.samjin.design.authnticationmanager;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private int timeToLive;
    private Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId)) {
            // 检查 token 是否过期
            if (tokens.get(tokenId) > currentTime) {
                tokens.put(tokenId, currentTime + timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expiryTime : tokens.values()) {
            if (expiryTime > currentTime) {
                count++;
            }
        }
        return count;
    }
}
