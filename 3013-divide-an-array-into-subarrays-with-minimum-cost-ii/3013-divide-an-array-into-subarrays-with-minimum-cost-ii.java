import java.util.*;

class Solution {

    private PriorityQueue<Integer> smalls = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> bigs = new PriorityQueue<>();
    private Map<Integer, Integer> toRemove = new HashMap<>();
    private long windowSum = 0;
    private int smallsSize = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int m = k-2;

        for (int i=2; i<=Math.min(dist+1, n-1); i++) {
            add(nums[i], m);
        }

        long minCost = nums[0]+nums[1]+windowSum;

        for (int i=2; i<=n-(m+1); i++) {
            remove(nums[i], m);

            if(i+dist<n) {
                add(nums[i+dist], m);
            }

            minCost = Math.min(minCost, (long) nums[0]+nums[i]+windowSum);
        }

        return minCost;
    }

    private void add(int val, int m) {
        if (smallsSize<m || val<smalls.peek()) {
            smalls.add(val);
            windowSum += val;
            smallsSize++;
        } else {
            bigs.add(val);
        }
        rebalance(m);
    }

    private void remove(int val, int m) {
        if(!smalls.isEmpty() && val<=smalls.peek()) {
            windowSum -= val;
            smallsSize--;
        }
        toRemove.put(val, toRemove.getOrDefault(val, 0)+1);
        clean(smalls);
        clean(bigs);
        rebalance(m);
    }

    private void rebalance(int m) {
        if(smallsSize>m) {
            int val = smalls.poll();
            windowSum -= val;
            smallsSize--;
            bigs.add(val);
            clean(smalls);
        }

        if(smallsSize<m && !bigs.isEmpty()) {
            int val = bigs.poll();
            windowSum += val;
            smallsSize++;
            smalls.add(val);
            clean(bigs);
        }
    }

    private void clean(PriorityQueue<Integer> pq) {
        while(!pq.isEmpty() && toRemove.getOrDefault(pq.peek(), 0)>0) {
            int val = pq.poll();
            toRemove.put(val, toRemove.get(val)-1);
        }
    }
}