class Solution {
    public int getSum(int a, int b) {

    int carry = (a&b) << 1;

    if (carry == 0) return a^b;

    return getSum(a^b, carry);
    }
}
