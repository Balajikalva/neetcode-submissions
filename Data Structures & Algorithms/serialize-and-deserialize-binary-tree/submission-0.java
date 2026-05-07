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

        Map<Integer, Integer> map = new HashMap<>();

        helper(root, 1, map);

        System.out.println(map);

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            builder.append(pair.getKey());
            builder.append(':');
            builder.append(pair.getValue());
           builder.append("#");
        }

        System.out.println(builder);

        if (!builder.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
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

        Map<Integer, Integer> map = new HashMap<>();

        if (data == null || data.isEmpty()) return null;

        String[] str = data.split("#");

        for (String pair : str) {

            String[] pairSplit = pair.split(":");
            // if (pairSplit.length != 2) continue;
            int key = Integer.parseInt(pairSplit[0]);
            int val = Integer.parseInt(pairSplit[1]);

            map.put(key, val);
        }
        
        return helper(1, map);
    }

    private TreeNode helper(int ind, Map<Integer, Integer> map) {

        if (!map.containsKey(ind)) {
            return null;
        }
        
        TreeNode root = new TreeNode(map.get(ind));
        
        root.left = helper(2 * ind, map);
        root.right = helper((2* ind) + 1, map);
        
        return root;
    }
}
