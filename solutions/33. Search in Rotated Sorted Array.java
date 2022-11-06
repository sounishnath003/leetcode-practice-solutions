class Solution {
	public int search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int midelem = nums[mid];

			if (midelem == target)
				return mid;

			if (nums[lo] <= midelem) {
				if (nums[lo] <= target && target < midelem) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (midelem < target && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}

		return nums[lo] == target ? lo : -1;
	}
}
