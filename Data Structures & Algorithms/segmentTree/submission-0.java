// package in.chinna.segmentree;

class SegmentTree {

    private Node root;

    public SegmentTree(int[] nums) {

        this.root = build(nums, 0, nums.length - 1);
        printTree(this.root);
    }

    public void update(int index, int val) {
        update(root, index, val);
        System.out.println("==============Start==========");
        printTree(root);
        System.out.println("==============End==========");
    }

    public int query(int L, int R) {

        return queryHelper(root, L, R);
    }

    private int queryHelper(Node node, int L, int R) {
        if (L <= node.left && node.right <= R) {
            return node.sum;
        }
        if (R < node.left || L > node.right) {
            return 0;
        }
        return queryHelper(node.lNode, L, R) + queryHelper(node.rNode, L, R);
    }

    private void printTree(Node node) {

        if (node == null) return;
        System.out.println(node);
        printTree(node.lNode);
        printTree(node.rNode);
    }

    private void update(Node node, int index, int val) {

        if (node.left == index && node.right == index) {
            node.sum = val;
            return;
        }

        int mid = (node.left + node.right) / 2;

        if (index <= mid) {
            update(node.lNode, index, val);
        } else {
            update(node.rNode, index, val);
        }

        node.sum =
            (node.lNode.sum) + (node.rNode.sum);
    }

    public Node build(int[] nums, int l, int r) {

        if (l == r) {
            return new Node(nums[l], l, r);
        }

        int mid = (l + r) / 2;
        return new Node(l, r, build(nums, l, mid), build(nums, mid + 1, r));
    }

    private static class Node {

        int sum;
        int left;
        int right;
        Node lNode;
        Node rNode;

        public Node(int sum,int left, int right) {

            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        public Node (int left, int right, Node lNode, Node rNode) {
            this.left = left;
            this.right = right;
            this.lNode = lNode;
            this.rNode = rNode;
            this.sum = lNode.sum + rNode.sum;
        }

        @Override
        public String toString() {

            return String.format("sum : %d ^&^ left : %d ^&^ right : %d", sum, left, right);
        }
    }
}


