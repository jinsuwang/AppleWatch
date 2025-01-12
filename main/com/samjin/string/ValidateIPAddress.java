package com.samjin.string;

public class ValidateIPAddress {

    public String validIPAddress(String queryIP) {
        if(isValidIPv4(queryIP)){
            return "IPv4";
        }

        if(isValidIPv6(queryIP)){
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        if(ip.length() < 7) return false;
        if(ip.charAt(0) == '.') return false;
        if(ip.charAt(ip.length() - 1) == '.') return false;

        String[] tokens = ip.split("\\.");
        if(tokens.length != 4) return false;

        for(String token : tokens){
            if(!isValidIPv4Token(token)){
                return false;
            }
        }

        return true;
    }


    private boolean isValidIPv4Token(String token) {
        if(token.startsWith("0") && token.length() > 1){
            return false;
        }

        // 0-255
        try {
            int num = Integer.valueOf(token);
            if(num < 0 || num > 255) return false;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean isValidIPv6(String ip){
        if(ip.length() < 15) return false;
        if(ip.charAt(0) == ':') return false;
        if(ip.charAt(ip.length() - 1) == ':') return false;

        String[] tokens = ip.split(":");
        if(tokens.length != 8) return false;

        for(String token : tokens){
            if(!isValidIPv6Token(token)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6Token(String token) {
        if(token.length() > 4 || token.length() == 0) return false;

        // 数字, a-f, A-F
        for(char c : token.toCharArray()){
            boolean isDigit = c >= 48 && c <= 57;
            boolean isUppercase = c >= 65 && c <= 70;
            boolean isLowercase = c >= 97 && c <= 102;
            if(!isDigit && !isUppercase && !isLowercase){
                return false;
            }
        }

        return true;
    }
}
