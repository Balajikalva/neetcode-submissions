class Solution {
    public int characterReplacement(String s, int k) {

        int maxLength = 0;
        
        for (int i = 0;i < s.length(); i++) {

            maxLength = Math.max(maxLength, getMaxLength(s, i, k));
        }

        return maxLength;
    }

    public int getMaxLength(String str, int ind, int k) {

        char maxChar = 'i';
        int maxCount = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = ind; i < str.length(); i++) {

            char ch = str.charAt(i);
            int count = freqMap.getOrDefault(ch, 0) + 1;

            if (count > maxCount) {

                maxCount = count;
            }

            freqMap.put(ch, count);

            if (i - ind + 1 - maxCount > k) {

                return i - ind;
            }
        }

        return str.length() - ind;
    }
}
