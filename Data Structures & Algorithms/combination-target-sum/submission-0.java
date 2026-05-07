class Solution {

    List<List<Integer>> sol = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        helper(nums, 0, target, new ArrayList<>());
        return sol;
    }

    public void helper(int[] nums, int ind, int sum, List<Integer> list) {

        if (ind == nums.length) return;

        if (sum == 0) {

            sol.add(new ArrayList<>(list));
            return;
        }

        helper(nums, ind + 1, sum, list);

        if (sum >= nums[ind]) {

            int len = list.size();

            list.add(nums[ind]);
            helper(nums, ind, sum - nums[ind], list);
            list.remove(len);
        }
    }
}
