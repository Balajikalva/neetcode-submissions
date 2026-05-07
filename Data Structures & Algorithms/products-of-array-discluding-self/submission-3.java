class Solution {

  public int[] productExceptSelf(int[] nums) {

    if (nums.length <= 1) {
      return nums;
    }

    int zeroCount = 0;

    for (int num : nums) {

      if (num == 0) {
        zeroCount++;
      }
    }

    if (zeroCount >= 2) {
      return new int[nums.length];
    }

    return helper(nums, zeroCount);
  }

  private int[] helper(int[] nums, int zeroCount) {

    int[] sol = new int[nums.length];
    long product = 1;

    for (int num : nums) {
      if (num == 0) {
        continue;
      }
      product *= num;
    }

    for (int i = 0; i < sol.length; i++) {

      if (zeroCount == 0) {
        sol[i] = (int) (product / (long) nums[i]);
      } else if (nums[i] == 0) {
        sol[i] = (int) product;
      }
    }

    return sol;
  }
}  