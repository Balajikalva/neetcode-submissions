class Solution {
    public int longestConsecutive(int[] nums) {
        
        int sol = 0;

		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

		for (int num : nums) {
			if (!set.contains(num - 1)) {

				int streak = 0;

				while(set.contains(num)) {
					streak++;
					num++;
				}

				if (sol < streak) sol = streak;
			}
		}

		return sol;

    }
}
