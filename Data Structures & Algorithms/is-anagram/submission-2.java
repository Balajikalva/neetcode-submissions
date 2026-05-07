class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] sr = s.toCharArray();
        char[] tr = t.toCharArray();

        Arrays.sort(sr);
        Arrays.sort(tr);

        for (int i = 0; i < sr.length;i++) {

            if (sr[i] != tr[i]) return false;
        }

        return true;
    }
}
