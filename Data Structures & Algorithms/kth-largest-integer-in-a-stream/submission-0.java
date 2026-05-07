class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.add(num);

            if (pq.size() > k) {

                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        
        addElement(val);
        return pq.peek();
    }

    private void addElement(int num) {

        pq.add(num);

            if (pq.size() > k) {

                pq.poll();
            }
    }
}
