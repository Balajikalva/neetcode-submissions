class Solution {
    public int characterReplacement(String s, int k) {

        if (s == null) return 0;
        

        int[] freq = new int[26];

        int l = 0;
        int maxCount = 0;

        int len = 0;

        for (int i = 0; i < s.length(); i++) {

            int ch = s.charAt(i) - 'A';
            freq[ch]++;

            maxCount = getMax(freq);

            while (l < i && i - l + 1 - maxCount > k) {

                ch = s.charAt(l) - 'A';
                freq[ch]--;
                l++;
                maxCount = getMax(freq);
            }

            if (len < i - l + 1) {

                len = i - l + 1;
            }
            
        }

        return len;
    }

    public int getMax(int[] nums) {

        int max = 0;

        for (int num : nums) {

            if (max < num) max = num;
        }

        return max;
    }
}
