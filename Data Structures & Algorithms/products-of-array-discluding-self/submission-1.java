class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] sol = new int[nums.length];

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        int left = 1;
        int right = 1;

        for (int i = 0;i < nums.length;i++) {

            left *= nums[i];
            right *= nums[nums.length - 1 - i];

            leftProduct[i] = left;
            rightProduct[nums.length - 1 - i] = right;
        }


        for (int i = 0; i < nums.length; i++) {

            int leftValue = i - 1 >= 0 ? leftProduct[i - 1] : 1;
            int rightValue = i + 1 < nums.length ? rightProduct[i + 1] : 1;

            sol[i] = leftValue * rightValue;
        }

        return sol;
        
    }
}  
