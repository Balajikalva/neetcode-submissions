class Solution {
    public int reverseBits(int n) {

        int res = 0;
        
        for (int i = 32;i > 0 && n != 0; i--) {

           // System.out.println(n + " check :  " + (n & 1));

            if ((n & 1) == 1) {
                res = res | (1 << (i - 1));
                // System.out.println(res +" >> " + (1 << (i - 1)));
            }

            n >>= 1;
        }

        return res;
    }
}
