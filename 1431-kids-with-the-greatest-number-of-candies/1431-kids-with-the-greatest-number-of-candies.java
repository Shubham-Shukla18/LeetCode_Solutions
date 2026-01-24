import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // TC=> O(n), SC=>O(1), speed=> faster(direct memory access), object creation=>low(using primitive) and memory pressure=>very low 
        int maxCandies = candies[0];
        for (int candy : candies) {
            if(candy > maxCandies){
                maxCandies = candy;
            }
        }

        ArrayList<Boolean> resultList = new ArrayList<>(candies.length);
        for(int candy:candies){
            resultList.add(candy+extraCandies>=maxCandies);
        }

        return resultList;

        // using stream with TC=> O(n), SC=>O(n), Speed=>Slower (Lambda/Function overhead), 
        // Object creation=> High (Creates Boolean objects) and Memory Pressure => Medium (Garbage Collector has more to clean)
        // final int maxCandies = Arrays.stream(candies).max().orElse(0);

        // return Arrays.stream(candies)
        //              .mapToObj(c -> c + extraCandies>=maxCandies)
        //              .toList();
    }
}