class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max_avg = (double)sum/k;

        for(int i = k; i < nums.length; i++) {
            sum = (sum+nums[i]-nums[i-k]);
            double curr_avg = (double)sum/k;
            max_avg = Math.max(curr_avg, max_avg);
        }

        return max_avg;
    }
}