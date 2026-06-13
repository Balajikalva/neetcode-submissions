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

    Node p, q;

    public Node lowestCommonAncestor(Node p, Node q) {
        
        this.p = p;
        this.q = q;

        return helper(p, q);

    }

    private Node helper(Node n1, Node n2) {

        if (n1 == n2) {

            return n1;
        }

        return helper(n1.parent != null ? n1.parent : p, n2.parent != null ? n2.parent : q);
    }


}