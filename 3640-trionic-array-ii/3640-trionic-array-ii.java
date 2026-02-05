import java.util.*;

class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        if(n<4) return Long.MIN_VALUE;

        long[] L = new long[n];
        Arrays.fill(L, Long.MIN_VALUE);

        for(int i=1; i<n; i++) {
            if(nums[i]>nums[i-1]) {
                long justPair = (long) nums[i] + nums[i-1];

                long extended = Long.MIN_VALUE;
                if(L[i-1]!=Long.MIN_VALUE){
                    extended = L[i-1] + nums[i];
                }

                L[i] = Math.max(justPair, extended);
            }
        }

        long[] R = new long[n];
        Arrays.fill(R, Long.MIN_VALUE);

        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                long justPair = (long) nums[i]+nums[i+1];

                long extended = Long.MIN_VALUE;
                if(R[i+1]!=Long.MIN_VALUE){
                    extended = nums[i]+R[i+1];
                }

                R[i]=Math.max(justPair, extended);
            }
        }

        long[] pref = new long[n+1];
        for (int i=0; i<n; i++) {
            pref[i+1] = pref[i]+nums[i];
        }

        long globalMax = Long.MIN_VALUE;


        int i=0;
        while(i<n-1){
            if(nums[i]>nums[i+1]){
                int start = i;

                while(i<n-1 && nums[i]>nums[i+1]){
                    i++;
                }
                int end=i;

                long maxValP = Long.MIN_VALUE;

                for(int k=start; k<=end; k++){
                    if(R[k]!=Long.MIN_VALUE && maxValP!=Long.MIN_VALUE){
                        long currentScore = maxValP + (R[k]+pref[k]);

                        if(globalMax == Long.MIN_VALUE || currentScore>globalMax){
                            globalMax = currentScore;
                        }
                    }

                    if(L[k] != Long.MIN_VALUE) {
                        long valP = L[k] - pref[k+1];
                        if(maxValP==Long.MIN_VALUE || valP>maxValP) {
                            maxValP = valP;
                        }
                    }
                }
            } else {
                i++;
            }

        }
        return globalMax;
    }
}