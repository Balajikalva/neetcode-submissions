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

    List<List<Integer>> sol;

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        sol = new ArrayList<>();
        travel(root, 0);
        return sol;
    }

    private void travel(TreeNode node, int level) {

        if (node == null) return;

        if (level == sol.size()) {
            sol.add(new ArrayList<>());
        }

        sol.get(level).add(node.val);

        travel(node.left, level + 1);
        travel(node.right, level + 1);


    }
}
