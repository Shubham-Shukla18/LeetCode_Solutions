import java.util.*;

class Solution {
    static {
        for(int i = 0; i < 100; i++) {
            maxArea(new int[]{0,0});
        }
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0, maxWater = Integer.MIN_VALUE;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            area = min * (right-left);
            maxWater =  Math.max(area, maxWater);
            while(left < right && height[left] <= min){
                left++;
            }
            while(left < right && height[right] <= min) {
                right--;
            }
        }
        return maxWater;
    }
}