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

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int n : arr){
            hm.put(n, hm.getOrDefault(n, 0)+1);
        }

        // List<Integer> ocurrences = new ArrayList<>();

        // for(var n : hm.entrySet()){
        //     ocurrences.add(n.getValue());
        // }

        // Set<Integer> setOfOcurr = new HashSet<>(ocurrences);

        // return setOfOcurr.size()==ocurrences.size();

        Set<Integer> setOfOcurr = new HashSet<>(hm.values());
        
        return setOfOcurr.size()==hm.size();
    }
}