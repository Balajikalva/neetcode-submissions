class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1 == null && s2 == null && s3 == null) return true;
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s3.length() != s1.length() + s2.length()) return false;

        return helper(s1, s2, s3, 0,0,0);   
    }

    public boolean helper(String s1, String s2, String s3, int l1, int l2, int l3) {

        if (l3 == s3.length()) {

            return true;
        }

        if (l1 == s1.length()) {

            while(l3 < s3.length() && s3.charAt(l3) == (s2.charAt(l2))) {

                l3++;
                l2++;
            }

            return l2 == s2.length();
        }

        if (l2 == s2.length()) {

            while(l3 < s3.length() && s1.charAt(l1) == s3.charAt(l3)) {
                l3++;
                l1++;
            }

            return l1 == s1.length();
        }

        if (s1.charAt(l1) == s3.charAt(l3)) {

            if (helper(s1, s2, s3, l1 + 1, l2 , l3 + 1)) return true;
        }

        if (s2.charAt(l2) == s3.charAt(l3)) {
            if (helper(s1,s2,s3, l1, l2 + 1, l3 + 1)) return true;
        }

        return false;

    }

    // private boolean 
}
