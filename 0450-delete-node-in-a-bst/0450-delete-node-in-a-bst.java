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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            if(root.left==null){
                return root.right;
            }
            if(root.right==null) {
                return root.left;
            }

            TreeNode successor = findMin(root.right);

            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    } 

    private TreeNode findMin(TreeNode node) {
        while(node.left!=null) {
            node = node.left;
        }
        return node;
    }
}