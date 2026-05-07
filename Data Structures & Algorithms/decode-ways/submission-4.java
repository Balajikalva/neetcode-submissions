class Solution {
    public int numDecodings(String s) {
        
        return helper(s, 0);
    }

    public int helper(String s, int ind) {

        if (ind == s.length()) return 1;

        if (s.charAt(ind) == '0') return 0;

        int n1 = Character.getNumericValue(s.charAt(ind));

        if (ind + 1 < s.length()) {

            int n2 = Character.getNumericValue(s.charAt(ind + 1));

            int num = (n1 * 10) + n2;

            if (n2 == 0 && n1 > 2) return 0;

            if (n2 == 0) {
                return helper(s, ind + 2);
            }

            if (num > 26) {

                return helper(s, ind + 1);
            }

            return helper(s, ind + 1) + helper(s, ind + 2);
        }

        return helper(s, ind + 1);
    }
}
