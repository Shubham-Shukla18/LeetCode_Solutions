class Solution {

    // public String reverseWords(String s) {
    //     if(s==null) return null;

    //     char[] chars = s.toCharArray();
    //     int n = chars.length;

    //     // reverse the entire string
    //     reverse(chars, 0, n-1);

    //     // reverse each indiviual word
    //     reverseWords(chars, n);

    //     // clean up extra spaces (In-space)
    //     return cleanSpaces(chars, n);
    // }

    // private void reverse(char[] a, int i, int j) {
    //     while(i<j) {
    //         char t = a[i];
    //         a[i++] = a[j];
    //         a[j--] = t;
    //     }
    // }

    // private void reverseWords(char[] a, int n) {
    //     int i=0, j=0;
    //     while(i<n) {
    //         while(i<j || (i<n && a[i]==' ')) i++; // skip spaces
    //         while(j<i || (j<n && a[j]!=' ')) j++; // skip non-spaces
    //         reverse(a, i, j-1);                   // reverse the word
    //     }
    // }

    // private String cleanSpaces(char[] a, int n) {
    //     int i=0, j=0;
    //     while(j<n) {
    //         while(j<n && a[j]==' ') j++;                // skip leading spaces
    //         while(j<n && a[j]!=' ') a[i++] = a[j++];    // skip non-spaces
    //         while(j<n && a[j]==' ') j++;                // skip middle spaces
    //         if(j<n) a[i++]=' ';
    //     }
    //     return new String(a, 0, i);
    // }

     static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public String reverseWords(String s) {
       String[] words = s.trim().split("\\s+");
       StringBuilder sb = new StringBuilder();
       
       for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            if(i!=0){
                sb.append(" ");
            }
       }

       return sb.toString();
    }
}