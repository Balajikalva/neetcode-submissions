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


        List<Integer> levelList;

        if (level < sol.size()) {
            levelList = sol.get(level);
        }else {
            levelList = new ArrayList<>();
            sol.add(levelList);
        }

        levelList.add(node.val);

        travel(node.left, level + 1);
        travel(node.right, level + 1);


    }
}
