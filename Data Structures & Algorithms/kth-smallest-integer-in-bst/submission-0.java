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

    int ans;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        
        this.k = k;
        helper(root);
        return ans;
    }

    public void helper(TreeNode root) {

        if (k == 0 || root == null) return;
        if (root.left != null) helper(root.left);
        if (--k == 0) ans = root.val;
        if (root.right != null) helper(root.right);
    }
}
