class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        int sol = left;

        while (left <= right && sol != 0) {
            sol &= left;
            left++;
        }

        return sol;
    }
}