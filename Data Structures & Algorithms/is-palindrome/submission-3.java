class Solution {
    public boolean isPalindrome(String str) {
        
        String s = str.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {

            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while(r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}
