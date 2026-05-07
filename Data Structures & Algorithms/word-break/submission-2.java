class Solution {

    Boolean[]dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        
        dp = new Boolean[s.length()];
        return helper(s, 0, wordDict);
    }

    public boolean helper(String s, int ind, List<String> wordDict) {

        if (ind == s.length()) return true;

        if (dp[ind] != null) return dp[ind];


        for (String word : wordDict) {

            if (word.length() + ind > s.length()) continue;

            if (word.equals(s.substring(ind , ind + word.length()))) {

                if (helper(s, ind + word.length(), wordDict)) return dp[ind] = true;
            }
        }

        return dp[ind] = false;
    }
}
