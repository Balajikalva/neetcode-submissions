class Solution {
    public int lastStoneWeight(int[] stones) {
        
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);

        for (int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {

            int w1 = pq.poll();
            int w2 = pq.poll();

            if (w1 != w2) pq.add(w1 - w2);
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}
