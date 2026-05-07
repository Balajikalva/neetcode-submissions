class Solution {
    public int longestConsecutive(int[] nums) {


        HashMap<Integer,Integer> map = new HashMap<>();

        int sol = 0;

        for (int i = 0;i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num)) {
                continue;
            }

            int val = map.getOrDefault(num - 1, 0) + 1;
            map.put(num , val);

            while(map.containsKey(num + 1)) {

                map.put(num + 1, val + 1);
                num++;
                val++;
            }
        }

        for (int val : map.values()) {

            if (sol < val) sol = val;
        }

        return sol;
        
    }
}
