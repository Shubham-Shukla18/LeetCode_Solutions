class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        int gcdLength = strGCD(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }

    private int strGCD(int a, int b) {
        int temp = 0;
        while(b!=0){
            temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    // recursive call
    //  public String gcdOfStrings(String str1, String str2) {
    //     if (str2.length() > str1.length()) {
    //         return gcdOfStrings(str2, str1);
    //     }
    //     if (str2.equals(str1)) {
    //         return str1;
    //     }
    //     if (str1.startsWith(str2)) {
    //         return gcdOfStrings(str1.substring(str2.length()), str2);
    //     }
    //     return "";
    // }
}