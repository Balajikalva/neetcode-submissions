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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        List<String> list = new ArrayList<>();
        helper(root, list);
        String str =  String.join("#", list);

        System.out.println(str);

        return str;

    }

    private void helper(TreeNode node, List<String> list) {

        if (node == null) {
            list.add("N");
            return;
        }

        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) return null;
        
        String[] nodes = data.split("#");

        return helper(nodes, new int[1]);

    }

    private TreeNode helper(String[] nodes, int[] ind) {

        if (nodes[ind[0]].equals("N")) {

            ind[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[ind[0]]));
        ind[0]++;

        node.left = helper(nodes, ind);
        node.right = helper(nodes, ind);

        return node;
    }
}
