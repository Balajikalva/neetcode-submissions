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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> sol = new ArrayList<>();

        if (root == null) return sol;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(que.isEmpty() == false) {

            int len = que.size();

            while(len-- > 0) {

                TreeNode node = que.remove();
                if (len == 0) sol.add(node.val);

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
        }

        return sol;
    }
}
