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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {

            return true;
        }

        if (root == null) return false;

        if (root.val != subRoot.val) {

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode one, TreeNode two) {

        if (one == null && two == null) return true;
        if (one == null || two == null) return false;

        return one.val == two.val && isSame(one.left, two.left) && isSame(one.right, two.right);
    }
}
