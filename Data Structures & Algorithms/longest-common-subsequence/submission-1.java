class Solution {

    Integer[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        
        this.dp = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0);
    }

    public int helper(String text1, String text2, int ind1, int ind2) {

        if (ind1 == text1.length() || ind2 == text2.length()) return 0;

        if (dp[ind1][ind2] != null) return dp[ind1][ind2];

        if (text1.charAt(ind1) == text2.charAt(ind2)) {

            return dp[ind1][ind2] = 1 + helper(text1, text2, ind1 + 1, ind2 + 1);
        }

        return dp[ind1][ind2] = Math.max(helper(text1, text2, ind1, ind2 + 1), helper(text1, text2, ind1 + 1, ind2));
    }
}
