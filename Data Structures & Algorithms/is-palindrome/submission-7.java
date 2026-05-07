class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {

            while(l < r && !checkIfAlphabet(s.charAt(l))) {
                l++;
            }

            while(l < r && !checkIfAlphabet(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean checkIfAlphabet(char ch) {

        int num = ch - '0';
        int val = ch - 'a';
        return (num >= 0 && num < 9) || (val >= 0 && val < 26);
    }
}
