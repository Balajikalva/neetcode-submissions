class Solution {
    public int reverse(int x) {
        
        boolean negative = x < 0;

        if (x == Integer.MIN_VALUE) return 0;

        if (x < 0) x *= -1;

        long sol = 0;

        while(x > 0) {

            int rem = x % 10;
            
            sol = (sol * 10) + rem;

            if (sol >= Integer.MAX_VALUE) return 0;

            x/=10;

        }

        if (negative) sol *= -1;

        return (int) sol;
    }
}
