class Solution {
    /**
        Approach=> Linear Scan (Greedy)
        TC=> O(n)
        SC=> O(1)
        Speed=> Ultra-Fast – Sequential memory access is CPU-cache friendly.
        object creation => zero
        memory pressure => Minimal stack space is used; no heap allocation
        Application => Real-time Stream Processing – Used in partitioning telemetry data or log batches where overhead must be near zero.
     */
    public int minimumCost(int[] nums) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++) {
            if(nums[i]<firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = nums[i];
            } else if (nums[i]<secondSmallest) {
                secondSmallest = nums[i];
            }
        }

        return nums[0]+firstSmallest+secondSmallest;
    }
}