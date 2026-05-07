class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0;i < piles.length; i++) {

            if (max < piles[i]) {
                max = piles[i];
            }
        }

        while(min <= max) {

            int time = 0;
            int mid = (min + max) / 2;

            for (int pile : piles) {

                int adder = 0;

                if (pile % mid != 0) {
                    adder = 1;
                }

                time += adder;
                time += (pile / mid);
            }

            if (time > h) {
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }

        return min;
    }
}
