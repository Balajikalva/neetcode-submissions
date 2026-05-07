class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int max = 0;

        for (int i = 0;i < s.length(); i++) {

            set.clear();

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                if (set.contains(ch)) {
                    break;
                }

                if (max < j - i + 1) {
                        max = j - i + 1;
                    }

                set.add(ch);
            }
        }

        return max;
    }
}
