class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0;i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            freq.put(c1, freq.getOrDefault(c1, 0) + 1);
            freq.put(c2, freq.getOrDefault(c2, 0) - 1);
        }

        for (int val : freq.values()) {

            if (val != 0) return false;
        }

        return true;
    }
}
