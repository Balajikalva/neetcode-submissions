class SegmentTree {

    Node tree;

    public SegmentTree(int[] nums) {

        this.tree = build(nums, 0, nums.length -1);
    }

    public void update(int index, int val) {

        if (tree == null) return;
        update(tree, index, val);
    }

    public int query(int L, int R) {

        if (tree == null) return 0;
        return query(tree, L, R);
    }

    private Node build(int[] nums, int l, int r) {

        if (l == r) {

            return new Node(l, r, nums[l]);
        }

        int mid = (l + r) / 2;

        Node left = build(nums, l, mid);
        Node right = build(nums, mid + 1, r);

        Node node = new Node(l, r, left.sum + right.sum);
        node.left = left;
        node.right = right;

        return node;
    }

    private void update(Node node, int ind, int val) {

        if (node.l == node.r && node.l == ind) {
            node.sum = val;
            return;
        }

        int mid = (node.l + node.r) / 2;

        if (ind <= mid) {
            update(node.left, ind, val);
        }else{
            update(node.right, ind, val);
        }

        node.sum = node.left.sum + node.right.sum;
        return;
    }

    private int query(Node node, int l, int r) {

        if (l > node.r || r < node.l) {
            return 0;
        }
        
        if (l <= node.l && r >= node.r) {
            return node.sum;
        }

        return query(node.left, l, r) + query(node.right, l , r);
    }

    class Node {

        int l,r,sum;
        Node left,right;

        Node(int l, int r, int sum) {

            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }
}
