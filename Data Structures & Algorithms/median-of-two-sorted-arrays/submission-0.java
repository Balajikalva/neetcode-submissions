class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        

        // keep the selection to be included

        if (nums1.length == 0 && nums2.length == 0) {

            return -1;
        }

        int l = 0;
        int r = nums1.length - 1;

        int medianLength = (nums1.length + nums2.length + 1) / 2;

        int totalLength = nums1.length + nums2.length;

        while (l <= r) {

            int mid = (l + r) / 2;
            int midVal = nums1[mid];

            int ind2 = getMinIndex(nums2, midVal);

            // elements in nums2 which are strictly less than what we have (mid-val) == ind2 + 1

            int len = ind2 + 1 + mid + 1;

            if (len == medianLength) {

                if (totalLength % 2 == 1) {

                    return Math.max(nums1[mid], nums2[ind2]);
                }

                return ((double) (nums1[mid] + nums2[ind2])) / 2;
            }

            if (len > medianLength) {

                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println("Reached to the end");

        return -1;

    }

    private int getMinIndex(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        int sol = Integer.MAX_VALUE;

        while (l <= r) {

            int m = (l + r) / 2;

            int mid = nums[m];

            if (mid < target) {
                l = m + 1;
            } else {

                sol = Math.min(sol, m);
                r = m - 1;
            }
        }

        return sol;
    }
}
