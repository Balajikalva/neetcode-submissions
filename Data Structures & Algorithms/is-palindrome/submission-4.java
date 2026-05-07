class Solution {
    public boolean isPalindrome(String s) {

        if (s == null) return true;

        int l = 0;
        int r = s.length() - 1;

        String str = s.toUpperCase();

        s = str;

        System.out.println("Upper Case String is : " + s);

        while(l < r) {

            System.out.print(String.format("l : %d :: r : %d", l, r));

            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {

                l++;
            }

            while(r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            System.out.print(String.format(" >>> l : %d :: r : %d", l, r));

            if (l < r && s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }

    // private boolean checkIfValid(char ch) {

    //     int val = ch - 'A';
    
    //     return val >= 0 && val <
    // }
}
