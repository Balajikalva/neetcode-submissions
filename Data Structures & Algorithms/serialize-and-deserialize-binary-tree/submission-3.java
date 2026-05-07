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

    public String serialize(TreeNode root) {

        List<String> preOrderTraversal = new ArrayList<>();
        serialize(root, preOrderTraversal);
        return String.join(",", preOrderTraversal);
    }

    private void serialize(TreeNode node, List<String> preOrderTraversal) {

        if (node == null) {
            preOrderTraversal.add("N");
            return;
        }

        preOrderTraversal.add(String.valueOf(node.val));
        serialize(node.left, preOrderTraversal);
        serialize(node.right, preOrderTraversal);
    }

    public void helper(TreeNode root, int ind,  Map<Integer,Integer> map) {

        if (root == null) {
            return;
        }

        map.put(ind, root.val);
        helper(root.left, ind * 2, map);
        helper(root.right, ( ind * 2) + 1, map);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) return null;
        String[] splitString = data.split(",");
        return deserialize(splitString, new int[1]);
    }

    public TreeNode deserialize(String[] data, int[] ind) {

        if (data[ind[0]].equals("N")) {
            ind[0]++;
            return null;
        }

        int val = Integer.parseInt(data[ind[0]]);

        TreeNode node = new TreeNode(val);
        ind[0]++;
        node.left = deserialize(data, ind);
        node.right = deserialize(data, ind);

        return node;
    }
}
