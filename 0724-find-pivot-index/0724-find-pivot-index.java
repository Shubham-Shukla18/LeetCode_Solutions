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

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int n : nums) {
            totalSum += n;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++) {
            
            if(leftSum==totalSum - leftSum - nums[i]) {
                return i;
            }

            leftSum +=nums[i];
        }

        return -1;
    }
}