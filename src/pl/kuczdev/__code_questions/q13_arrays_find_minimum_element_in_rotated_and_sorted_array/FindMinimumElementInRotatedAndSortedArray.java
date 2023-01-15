package pl.kuczdev.__code_questions.q13_arrays_find_minimum_element_in_rotated_and_sorted_array;
/*
   * Compute mid i.e low+high/2
   * Check if a[mid..high] is sorted
       * Minimum lies in left part so: low = mid+1;
   * Else
       * Minimum lies in right part, so: high = mid;
 */
public class FindMinimumElementInRotatedAndSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {16,19,21,25,3,5,8,10};
        System.out.println("Minimum element in array is 3. Answer is = " + getMinimumElementInRotatedAndSortedArray(arr, 0, arr.length-1));
    }

    private static int getMinimumElementInRotatedAndSortedArray(int[] arr, int low, int high) {
        int mid;
        while (low < high) {
            mid = low + ((high - low) / 2);

            if (arr[mid] > arr[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}