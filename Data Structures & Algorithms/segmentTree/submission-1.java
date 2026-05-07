class SegmentTree {

    Node tree;

    public SegmentTree(int[] nums) {
        this.tree = build(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        
        update(tree, index, val);
    }
    
    private void update(Node node, int index, int val) {
        
        if (node.l == node.r) {
            node.sum = val;
            return;
        }
        
        int mid = (node.l + node.r) / 2;
        
        if (index <= mid) {
            update(node.left, index, val);
        }else{
            update(node.right, index, val);
        }
        
        node.sum = node.left.sum + node.right.sum;
    }

    public int query(int L, int R) {
        
        return query(tree, L, R);
    }
    
    private int query(Node node, int l, int r) {
        
        if (l > node.r || r < node.l) {
            return 0;
        }
        
        if (l <= node.l && r >= node.r) {
            return node.sum;
        }
        
        return query(node.left, l, r) + query(node.right, l, r);
    }
    
    private Node build(int[] nums, int l, int r) {
        
        if (l == r) {
            return new Node(l,r, nums[l]);
        }
        
        int mid = (r + l) / 2;
        
        Node node = new Node(l, r, 0);
        
        Node left = build(nums, l, mid);
        Node right = build(nums, mid + 1, r);
        
        node.left = left;
        node.right = right;
        node.sum = left.sum + right.sum;
        
        return node;
        
    }

    class Node {

        int l,r, sum;
        Node left, right;

        Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }
}