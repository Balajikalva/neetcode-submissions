class Solution {

    List<List<Integer>> sol;

    public List<List<Integer>> permute(int[] nums) {
        
        sol = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return sol;

    }

    private void helper(int[] nums, int count, List<Integer> list) {

        if (count == nums.length) {

            sol.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0;i < nums.length; i++) {

            if (nums[i] == 101) continue;

            int size = list.size();
            int num = nums[i];

            list.add(num);
            nums[i] = 101;

            helper(nums, count + 1, list);

            nums[i] = num;
            list.remove(size);
        }
    }
}
