class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] sol = new int[nums.length - k + 1];
        int ind = 0;

        for (int i = 0;i < nums.length; i++) {

            int num = nums[i];

            while (deq.size() > 0 && num >= nums[deq.peekLast()]) {
                deq.removeLast();
            }

            if (deq.size() > 0 && deq.peekFirst() == i - k) deq.removeFirst();
            deq.addLast(i);

            if (i + 1 >= k) {
                sol[ind++] = nums[deq.peekFirst()];
            }
            
        }

        return sol;
    }
}
