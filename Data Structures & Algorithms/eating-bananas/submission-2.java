class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = Integer.MIN_VALUE;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l <= r) {

            // System.out.println("l : "+l+" r : "+ r);

            int mid = (r + l) / 2;

            int time = timeForEating(piles, mid);

            if (time <= h) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        // System.out.println("l : "+l+" r : "+ r);
        return l;
    }

    public int timeForEating(int[] piles, int k) {

        int time = 0;

        for (int pile : piles) {

            time += ((pile) / k);
            if (pile % k != 0) time++;
        }

        // System.out.println(String.format("time : %d for rate : %d", time, k));

        return time;
    }
}
