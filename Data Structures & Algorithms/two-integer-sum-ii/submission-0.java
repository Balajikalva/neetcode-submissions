class Solution {
    public int[] twoSum(int[] numbers, int target) {
        

        int r = numbers.length - 1;
        int l = 0;

        while(l < r) {

            int sum = numbers[l] + numbers[r];

            if (sum == target) {

                return new int[]{++l, ++r};
            }

            if (sum < target) {
                l++;
            }else {
                r--;
            }
        }

        return new int[0];
    }
}
