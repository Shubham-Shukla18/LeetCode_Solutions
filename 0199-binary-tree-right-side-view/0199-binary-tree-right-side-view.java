import java.util.*;

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
// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root==null) {
//             return result;
//         }

//         Queue<TreeNode> queue = new ArrayDeque<>();
//         queue.offer(root);

//         while(!queue.isEmpty()) {
//             int levelSize = queue.size();

//             for(int i = 0; i < levelSize; i++) {
//                 TreeNode currNode = queue.poll();

//                 if(i==levelSize-1) {
//                     result.add(currNode.val);
//                 }

//                 if(currNode.left!=null) {
//                     queue.offer(currNode.left);
//                 }
//                 if(currNode.right!=null) {
//                     queue.offer(currNode.right);
//                 }
//             }
//         }

//         return result;
//     }
// }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        rightSideHelper(root, res, 0);
        return res;
    }

    void rightSideHelper(TreeNode root, List<Integer> res, int depth) {
        if(root==null) return ;

        if(depth == res.size()) {
            res.add(root.val);
        }

        rightSideHelper(root.right, res, depth+1);
        rightSideHelper(root.left, res, depth+1);
    }
}
