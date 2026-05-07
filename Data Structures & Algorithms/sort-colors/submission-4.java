class Solution {
    public void sortColors(int[] nums) {
        
        // assumption l, r doesn't carry 0 and 2 respectively
        // l -1 and r + 1 will have 0 and 2s

        int l = 0;
        int mid = 0;
        int r = nums.length - 1;

        while (mid <= r) {

            int num = nums[mid];

            if (num == 0) {

                swap(nums, mid, l);
                l++;
                mid++;
            }else if (num == 1) {
                mid++;
            }else {
                swap(nums, mid, r);
                r--;
            }

        }
    }

    private void swap(int[] nums, int ind1, int ind2) {

        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}