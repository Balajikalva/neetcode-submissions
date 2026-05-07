class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> sol = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int target = -1 * nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r) {

                while(l + 1 < r && nums[l] == nums[l + 1]) {
                    l++;
                }

                while(r - 1 > l && nums[r] == nums[r-1]) {
                    r--;
                }

                int sum = nums[l] + nums[r];

                if (sum == target) {

                    List<Integer> data = new ArrayList<>();

                    data.add(nums[i]);
                    data.add(nums[l]);
                    data.add(nums[r]);

                    sol.add(data);


                    l++;
                    r--;

                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

             while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }


        }

        return sol;


    }
}
