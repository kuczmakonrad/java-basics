package pl.kuczdev.__code_questions.q12_arrays_search_element_in_rotated_and_sorted_array;
/*
You are given an sorted and rotated array as below
 {16,19,21,25,3,5,8,10}
If you note that array is sorted and rotated.
You need to search an element in above array in o(log n) time complexity


You can search an element in above array using linear search, but that will take o(n).
You can use variant of binary search algorithm to solve above problem.
You can use a property that you can divide arry into two sorted sub arrays({16,19,21,25},{3,5,8,10}), althrough you dont need to find pivot point (Elements start decreasing).

Algorithm
    * Compute mid i.e low+high/2
    * Check if a[mid..high] is sorted
        * If number lies between the range, low = mid+1;
        * If number does not lie in the range, high = mid-1;

    * Check if a[low..mid] is sorted.
        * If number lies between the range, high = mid-1;
        * If number does not lie in the range, low = mid+1;

 */
public class SearchElementInRotatedAndSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{16,19,21,25,3,5,8,10};
        System.out.println("Element 5 is on index = " + findIndexOfElementByBinarySearch(arr, 0, arr.length-1, 5));
    }

    private static int findIndexOfElementByBinarySearch(int[] arr, int low, int high, int number) {
        int mid;
        while (low <= high) {
            mid = low + ((high-low) / 2);

            if (arr[mid] == number) {
                return mid;
            }

            if (arr[mid] <= arr[high]) {
                if(number > arr[mid] && number <= arr[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                //Left part is sorted
                if (arr[low] <= number && number < arr[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}

