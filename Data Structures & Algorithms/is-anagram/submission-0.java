class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] counter = new int[256];

        for (int i = 0;i < s.length(); i++) {

            int c1 = (int) (s.charAt(i));
            int c2 = (int) (t.charAt(i));

            counter[c1]++;
            counter[c2]--;
        }

        for (int count : counter) {

            if (count != 0) return false;
        }

        return true;
    }
}
