class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n<4) return false;

        int i=0;
        
        // Strictly increasing (nums[0....p])
        if(i+1<n && nums[i]<nums[i+1]){
            while(i+1<n && nums[i]<nums[i+1]){
                i++;
            }
        } else {
            return false;
        }

        int p=i;

        // Strictly decreasing (nums[p....q])
        if(i+1<n && nums[i]>nums[i+1]){
            while(i+1<n && nums[i]>nums[i+1]) {
                i++;
            }
        } else {
            return false;
        }

        int q=i;

        // Strictly increasing (nums[q...n-1])
        if(i+1<n && nums[i]<nums[i+1]){
            while(i+1<n && nums[i]<nums[i+1]){
                i++;
            }
        } else {
            return false;
        }

        return i==n-1;
    }
}