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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> sol = new ArrayList<>();

        if (root == null) return sol;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(que.isEmpty() == false) {

            int len = que.size();
            List<Integer> list = new ArrayList<>();

            while(len-- > 0) {

                TreeNode node = que.remove();
                list.add(node.val);

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

            sol.add(list);
        }

        return sol;
    
    }
}
