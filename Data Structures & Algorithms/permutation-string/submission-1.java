class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;

        int k = s1.length();
        if (k == 0) return true;

        for (int i = 0;i < s2.length(); i++) {

            if (i + k <= s2.length()) {

                if (isPermutation(s1, s2.substring(i, i + k))) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean isPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int[] counter = new int[26];

        for (int i  = 0;i < s1.length(); i++) {

            counter[s1.charAt(i) - 'a']++;
            counter[s2.charAt(i) - 'a']--;
        }

        for (int num : counter) {

            if (num != 0) return false;
        }

        return true;
    }
}
