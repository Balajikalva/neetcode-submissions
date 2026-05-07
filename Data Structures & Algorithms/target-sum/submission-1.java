class Solution {

    Map<String,Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        
        this.map = new HashMap<>();
        return index(nums, 0, 0, target);
    }

    public int index(int[] nums, int ind,int sum,int target) {

        if (ind == nums.length) {

            if (sum == target) {

                return 1;
            }

            return 0;
        }

        String str = String.format("ind : %d :: sum : %d", ind, sum);

        if (map.containsKey(str)) {
            return map.get(str);
        }

        int sol = index(nums, ind + 1, sum + nums[ind], target) + index(nums, ind + 1, sum - nums[ind], target);
        map.put(str, sol);

        return sol;
    }
}
