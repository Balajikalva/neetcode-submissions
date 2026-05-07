class Solution {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }

    private boolean helper(String s, int ind, int sum) {

        if (ind ==  s.length()) {
            return sum == 0;
        }

        if (sum < 0) return false;

        char ch = s.charAt(ind);

        if (ch == '(') {

            return helper(s, ind + 1, sum + 1);
        }

        if (ch == ')') {

            return helper(s, ind + 1, sum - 1);
        }

        return helper(s, ind + 1, sum) || helper(s, ind + 1, sum + 1) || helper(s, ind + 1, sum - 1);        
    }
}
