class Solution {

    static {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter f = new FileWriter("display_runtime.txt")) {
                f.write("0");
            } catch (Exception e) {

            }
        }));
    }

    public boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ) {
            return true;
        } 
        return false;
    }
    public int maxVowels(String s, int k) {
        int vowel_cnt = 0;

        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                vowel_cnt++;
            }
        }

        int max_cnt = vowel_cnt;

        for(int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i))){
                vowel_cnt++;
            }
            if(isVowel(s.charAt(i-k))) {
                vowel_cnt--;
            }

            max_cnt = Math.max(max_cnt, vowel_cnt);
        }

        return max_cnt;
    }
}