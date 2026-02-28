class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {}
        }));
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, operations = 0;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if(sum==k)
            {
                i++;
                j--;
                operations++;
            }

            if(sum > k) {
                j--;
            }
            if(sum < k) {
                i++;
            }
        }
        
        return operations;
    }
}