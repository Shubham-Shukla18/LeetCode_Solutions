class Solution {
    public int compress(char[] chars) {
        int a=0;
        int b=0;

        while(a<chars.length) {
            char currentChar = chars[a];
            int cnt=0;

            while(a<chars.length && chars[a]==currentChar){
                a++;
                cnt++;
            }

            chars[b++]=currentChar;

            if(cnt>1) {
                for(char c:Integer.toString(cnt).toCharArray()){
                    chars[b++] = c;
                }
            }
        }

        return b;
    }
}