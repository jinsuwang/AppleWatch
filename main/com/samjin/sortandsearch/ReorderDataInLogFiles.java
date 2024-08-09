package com.samjin.sortandsearch;

import java.util.Arrays;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        // Custom comparator to sort logs
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // Both are letter-logs
            if (!isDigit1 && !isDigit2) {
                // Compare by content first, then by identifier if necessary
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }

            // If one is a letter-log and the other is a digit-log, the letter-log comes first
            if (!isDigit1 && isDigit2) return -1;
            if (isDigit1 && !isDigit2) return 1;

            // Both are digit-logs, maintain original order
            return 0;
        });

        return logs;

    }
}
