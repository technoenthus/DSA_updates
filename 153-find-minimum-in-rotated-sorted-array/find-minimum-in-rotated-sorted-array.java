class Solution {
    public static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // Check if mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } 
            // Check if mid is the pivot (mid - 1 is smaller)
            else if (start < mid && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } 
            // Move towards the unsorted half
            else if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // This should never be reached if the input is a rotated sorted array
    }
    public int findMin(int[] nums) {
        int pivot=pivot(nums);
        return nums[pivot+1];
    }
}