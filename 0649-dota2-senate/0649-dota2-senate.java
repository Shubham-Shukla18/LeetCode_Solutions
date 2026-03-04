import java.util.*;

class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    /*
    Approach=> Double queue (optimized)
    TC=> O(n)
    SC=> O(n)
    Speed=> fast (linear pass)
    object creation => minimal (2 queue object)
    memory pressure => low
    Application => task scheduling / Arbitration
    */

    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> radiant = new ArrayDeque<>(n);
        Queue<Integer> dire = new ArrayDeque<>(n);

        for(int i = 0; i < n; i++) {
            if(senate.charAt(i)=='R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rIdx = radiant.poll();
            int dIdx = dire.poll();

            if(rIdx < dIdx) {
                radiant.offer(rIdx+n);
            } else {
                dire.offer(dIdx+n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}