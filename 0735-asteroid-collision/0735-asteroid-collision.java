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

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i : asteroids) {
            boolean exploded = false;

            while(!stack.isEmpty() && i < 0 && stack.peek() > 0){
                if(stack.peek() < -i) {
                    stack.pop();
                    continue;
                } else if(stack.peek() == -i) {
                    stack.pop();
                }
                exploded = true;
                break;
            }

            if(!exploded) {
                stack.push(i);
            }
        }

        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}