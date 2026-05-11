class Solution {

    boolean[][] dp;
    List<List<String>> sols = new ArrayList<>();

    public List<List<String>> partition(String s) {

        int n = s.length();
        
        this.dp = new boolean[n][n];

        for (int i = 0;i < s.length(); i++) {

            matchTillPalindrome(s, i, i);
            matchTillPalindrome(s, i, i + 1);
        }

        // for (int i = 0;i < dp.length; i++) {

        //     System.out.println(Arrays.toString(dp[i]));
        // }

        helper(0, s, new ArrayList<>());

        return sols;

    }


    private void helper(int ind, String s, List<String> selections) {

        if (ind == s.length()) {

            sols.add(new ArrayList<>(selections));

            return;
        }

        for (int i = ind; i < s.length(); i++) {

            if (dp[ind][i] != true) continue;

            String sub = s.substring(ind, i + 1);

            selections.add(sub);
            helper(i + 1, s, selections);

            selections.remove(selections.size() - 1);
        }

        return;
    }

    private boolean matchTillPalindrome(String s, int ind1, int ind2) {

        if (ind1 < 0 || ind2 == s.length()) {

            return false;
        }

        while (ind1 >= 0 && ind2 < s.length()) {

            if (s.charAt(ind1) == s.charAt(ind2)) {

                dp[ind1][ind2] = true;

                ind1--;
                ind2++;
            }

            return false;
        }

        return true;
    }
}
