class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0;i < nums.length; i++) {

            int need = target - nums[i];

            if (indexMap.containsKey(need)) {

                return new int[] {indexMap.get(need), i};
            }

            indexMap.put(nums[i], i);
        }

        return new int[0];
    }
}
