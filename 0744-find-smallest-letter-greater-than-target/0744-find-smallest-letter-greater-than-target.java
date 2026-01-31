class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int targetAscii = (int) target;
        
        for (int i=0; i<letters.length; i++){
            if(targetAscii<(int)letters[i]){
                return letters[i];
            }
        }

        return letters[0];
    }
}