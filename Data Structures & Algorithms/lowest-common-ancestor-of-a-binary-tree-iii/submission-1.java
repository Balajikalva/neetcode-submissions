/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        int h1 = height(p);
        int h2 = height(q);

        if (h1 > h2) {
           lowestCommonAncestor(q, p); 
        }

        // h1 is less than or equal to h2;

        int diff = h2 - h1;

        while (diff > 0) {

            q = q.parent;
            diff--;
        }

        while (p != q) {

            p = p.parent;
            q = q.parent;
        }

        return p;
    }

    private int height(Node node) {

        int h = 0;

        while (node != null) {

            node = node.parent;
            h++;
        }

        return h;
    }
}