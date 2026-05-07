class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int i = 0; i < nums.length; ) {

            int num = nums[i];

            if (num - 1 == i) {
                i++;
            }else {
                int temp = nums[num - 1];
                if (temp == num) return num;

                nums[num - 1] = num;
                nums[i] = temp;
            }
        }

        return -1;
    }
}
