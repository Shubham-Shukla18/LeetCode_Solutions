//import java.lang.Math;

class Solution {

    // My First approach time complexity is 4ms
    // public static boolean isInvalidString(String word) {
    //     return word==null || word.trim().isEmpty();
    // }

    // public String mergeAlternately(String word1, String word2) {
    //     if(isInvalidString(word1) && isInvalidString(word2)) {
    //         return "";
    //     }

    //     if(isInvalidString(word1)) {
    //         return word2;
    //     }

    //     if(isInvalidString(word2)) {
    //         return word1;
    //     }

    //     int word1_len = word1.length();
    //     int word2_len = word2.length();
    //     int max_len = Math.max(word1_len, word2_len);
    //     String result_word = "";

    //     for(int i=0; i<max_len; i++) {
    //         if(i<word1_len) {
    //             result_word +=word1.charAt(i);
    //         }
    //         if(i<word2_len) {
    //             result_word +=word2.charAt(i);
    //         }
    //     }

    //     return result_word;
    // }

    // new approach

    public String mergeAlternately(String word1, String word2) {
    StringBuilder result = new StringBuilder();

    int i=0;
    int len1 = word1.length();
    int len2 = word2.length();

    for(; i<len1 && i<len2; i++) {
        result.append(word1.charAt(i));
        result.append(word2.charAt(i));
    }

    if(i<len1) {
        result.append(word1.substring(i));
    }
    if(i<len2){
        result.append(word2.substring(i));
    }

    return result.toString();
    }

}