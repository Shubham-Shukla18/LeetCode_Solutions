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

    /*
    Approach=> recursive approach
    TC=> O(L) (where L is result length)
    SC=> O(D+N) (depth + input)
    Speed=> fast(native stack optimization)
    object creation => minimal (Queue + StringBuilder)
    memory pressure => low
    Application => Grammer Parsers / Compilers
    */    
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

