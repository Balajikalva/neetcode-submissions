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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || root.val == p.val || root.val == q.val) {

            return root;
        }

        TreeNode leftSol = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSol = lowestCommonAncestor(root.right, p, q);

        if (leftSol != null && rightSol != null) return root;
        if(leftSol == null) return rightSol;
        return leftSol;
    }
}
