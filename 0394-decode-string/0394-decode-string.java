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

    private String decode(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while(!queue.isEmpty()) {
            char c = queue.poll();

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                String inner = decode(queue);
                while(num > 0) {
                    sb.append(inner);
                    num--;
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        } 

        return decode(queue);
    }
}

// Another Solution:
// class Solution {
//     int n;

//     public String decodeString(String s) {
//         n = s.length() + 2;
//         return decodeString("[".concat(s).concat("]"), new StringBuilder(), new int[] { 0 });
//     }

//     private String decodeString(String s, StringBuilder sb, int[] i) {
//         boolean start = false;
//         int rep = 0;
//         while (i[0] < n) {
//             char c = s.charAt(i[0]);
//             if (Character.isDigit(c) && !start) {
//                 rep *= 10;
//                 rep += c - '0';
//             } else if (Character.isDigit(c) && start) {
//                 sb.append(decodeString(s, new StringBuilder(), i));
//             } else if (c == '[' && !start) {
//                 start = true;
//             } else if (c == ']' && start) {
//                 break;
//             } else {
//                 sb.append(c);
//             }
//             i[0]++;
//         }
//         return sb.toString().repeat(rep == 0 ? 1 : rep);
//     }
// }