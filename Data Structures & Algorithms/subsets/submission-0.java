class Solution {

    List<List<Integer>> sol = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, 0, new ArrayList<>());
        return sol;
    }

    public void helper(int[] nums, int ind, List<Integer> list) {

        if (ind == nums.length) {

           sol.add(new ArrayList<>(list));
           return;
        }

        // two choice add or not

        helper(nums, ind + 1, list);

        int len = list.size();
        list.add(nums[ind]);
        helper(nums, ind + 1, list);
        list.remove(len);
    }
}
