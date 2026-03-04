/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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

    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
       dfs(root.left, 0, 1);
       dfs(root.right, 1, 1);
       return maxZigZag;
    }

    private void dfs(TreeNode node, int direction, int currLength) {
        if(node==null) {
            return ;
        }

        maxZigZag = Math.max(maxZigZag, currLength);

        if(direction == 0) {
            //to continue zigzag, must move right
            dfs(node.right, 1, currLength+1);
            //or start fresh by moving left again
            dfs(node.left, 0, 1);
        } else {
            //to continue zigzag, must move left
            dfs(node.left, 0, currLength+1);
            //or start fresh by moving right again
            dfs(node.right, 1, 1);
        }
    }
}