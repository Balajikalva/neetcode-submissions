class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> sols = new ArrayList<>();


        Arrays.sort(nums);

        for (int i = 0;i < nums.length; i++) {

            int num = nums[i];
            int target = -1 * num;

            int l = i + 1;
            int r = nums.length - 1;


            while(l < r) {


                while(l < r && nums[l] == nums[l + 1]) {
                    l++;
                }

                while(r > l && nums[r] == nums[r-1]) {
                    r--;
                }

                int sum = nums[l] + nums[r];

                if (sum == target) {

                    sols.add(List.of(num, nums[l], nums[r]));
                    l++;
                    r--;
                }else if (sum > target) {

                    r--;
                }else {
                    l++;
                }
            }

            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return sols;
        
    }
}
