class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        StringBuilder builder = new StringBuilder();

        int ind = 0;

        while (true) {

            for (int i = 0;i < strs.length - 1; i++) {

                if (ind == strs[i].length() || ind >= strs[i + 1].length() || strs[i].charAt(ind) != strs[i + 1].charAt(ind)) {

                    return builder.toString();
                }
            }

            builder.append(strs[0].charAt(ind));
            ind++;
        }
    }
}