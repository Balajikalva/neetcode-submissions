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

    int sol = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return sol;

    }

    public int helper(TreeNode root) {

        if (root == null) return Integer.MIN_VALUE;

        int leftSum = root.left != null ? helper(root.left) : Integer.MIN_VALUE;
        int rightSum = root.right != null ? helper(root.right) : Integer.MIN_VALUE;

        sol = Math.max(sol, leftSum);
        sol = Math.max(sol, rightSum);

        int treeSum = root.val;

        if (leftSum != Integer.MIN_VALUE && rightSum != Integer.MIN_VALUE) {
            treeSum += Math.max(leftSum, rightSum);
            sol = Math.max(sol, root.val + leftSum + rightSum);
        }else if (leftSum != Integer.MIN_VALUE) {
            treeSum += leftSum;
        }else if (rightSum != Integer.MIN_VALUE){
            treeSum += rightSum;
        }

        sol = Math.max(treeSum, sol);

        return treeSum > 0 ? treeSum : Integer.MIN_VALUE;

    }
}
