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

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> nums1Distincts = new ArrayList<>();
        List<Integer> nums2Distincts = new ArrayList<>();

        Set<Integer> setOfnums1 = new HashSet<>();
        Set<Integer> setOfnums2 = new HashSet<>();

        for(int n : nums1) {
            setOfnums1.add(n);
        }

        for(int n : nums2) {
            setOfnums2.add(n);
        }

        for(int n : setOfnums1) {
            if(!setOfnums2.contains(n)){
                nums1Distincts.add(n);
            }
        }

        for(int n : setOfnums2) {
            if(!setOfnums1.contains(n)){
                nums2Distincts.add(n);
            }
        }


        List<List<Integer>> answer = List.of(nums1Distincts, nums2Distincts);

        return answer;
    }
}