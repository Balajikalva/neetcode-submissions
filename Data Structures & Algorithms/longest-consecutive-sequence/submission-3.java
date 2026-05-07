class Solution {
    public int longestConsecutive(int[] nums) {


        Arrays.sort(nums);

        int sol = 0;
        int count = 0;

        for(int i = 0; i < nums.length;i++){

            if (i > 0) {

                if (nums[i] == nums[i-1] + 1) {
                    count++;
                } else if (nums[i] != nums[i-1]) {
                    count = 1;
                }
            }else {
                count = 1;
            }

            if (sol < count) {
                sol = count;
            }
        }

        return sol;
    }
}
