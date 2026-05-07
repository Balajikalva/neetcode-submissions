class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;

        int[] counter = new int[26];

        for (char ch : s1.toCharArray()) {
            counter[ch - 'a']++;
        }

        int l = 0;
        int r = 0;

        int[] counter2 = new int[26];

        while(r < s2.length()) {

            int val = s2.charAt(r) - 'a';
            counter2[val]++;

            while(l <= r && counter2[val] > counter[val]) {
                counter2[s2.charAt(l++) - 'a']--;
            }

            if (r - l + 1 == s1.length()) return true;
            r++;
        }


        return false;

    }
}
