class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int sol = 0;

        for (int i = 0;i < s.length();i++) {

            char ch = s.charAt(i);

            if (map.containsKey(ch)) {

                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, i);

            if (sol < i - left + 1) {

                sol = i - left + 1;
            }
        }

        return sol;
    }
}
