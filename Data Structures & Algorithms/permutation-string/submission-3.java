class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;

        int[] counter = new int[26];

        for (char ch : s1.toCharArray()) {
           // System.out.println(ch);
            counter[ch - 'a']++;
        }

        int l = 0;
        int r = 0;

        int[] counter2 = new int[26];

        while(r < s2.length()) {

            int val = s2.charAt(r) - 'a';
            counter2[val]++;

            while(l <= r && counter2[val] > counter[val]) {

                int temp = s2.charAt(l) - 'a';
                // System.out.println(String.format("l : %d && temp : %d", l, temp));
                counter2[temp]--;
                l++;
            }

            if (r - l + 1 == s1.length()) return true;
            r++;
        }


        return false;

    }
}
