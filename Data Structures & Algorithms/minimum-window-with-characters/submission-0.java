class Solution {


    private int[] tCounter = new int[256];
    private int[] sCounter = new int[256];
    private int minLength = Integer.MAX_VALUE;

    public String minWindow(String s, String t) {
        
        if (t == null || s == null) return null;

        for (int i = 0; i < t.length(); i++) {

            int num = t.charAt(i);
            tCounter[num]++;
        }

        int minIndex = 0;

        int l = 0;
        int r = 0;
       
        while(r < s.length()) {

            int num = s.charAt(r);
            sCounter[num]++;

            while(checkPossible()) {

                if (minLength > r - l + 1) {

                    minLength = r - l + 1;
                    minIndex = l;
                }

                sCounter[s.charAt(l)]--;
                l++;
            }

            r++;

        }

        if (minLength == Integer.MAX_VALUE) return "";

        return s.substring(minIndex, minIndex + minLength);

    }

    public boolean checkPossible() {

        for (int i = 0;i < 256; i++) {

            if (sCounter[i] < tCounter[i]) return false;
        }

        return true;
    }

}
