package pl.kuczdev.__code_questions.q24_arrays_sliding_window_maximum;

/*
Given an Array of integers and an Integer k, Find the maximum element of from all the contiguous subarrays of size K.

For example:
    Input : int[] arr = {2,6,-1,2,4,1,-6,5}
    int k = 3
    output : 6,6,4,4,4,5
for every subarray of size k, Print its maximum element.

Naive Approach (solve):
The basic solution would be just generating all the contiguous subarrays of size k and looping over them for finding out the max in that current subarray.
Considering, for every spot we are basically taking next ‘k’ element and then we loop over those k elements,
so the worst time complexity of this algorithm would be O(n*k).

solve2 - is mine example
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,99,702,2345,2,345,5};
        //int[] arr ={2,6,-1,2,4,1,-6,5};
        solve(arr, 3);
        System.out.println("---");
        solve2(arr, 3);
    }

    public static void solve(int[] arr, int k) {
        // starting the outer loop from k and running it until current pointer is EQUAL to arr.length
        for(int i = k; i <= arr.length; i++) {
            int max = Integer.MIN_VALUE;

            // this loop considers subarrays of size k ending at i-1
            for(int j = i-k; j < i; j++) {
                max = Math.max(max, arr[j]);
            }

            System.out.println(max);
        }
    }

    public static void solve2(int[] arr, int k) {
        int first = 0;
        int last = k-1;
        int temp = arr[0];
        while (last <= arr.length - 1) {
            for (int i = first; i <= last; i++) {
                if (temp < arr[i]) temp = arr[i];
            }
            System.out.println("For elements between indexes: " + first + " and " + last + " highest value is " + temp);
            if (last == arr.length - 1) break;
            temp = arr[last+1];
            first++;
            last++;
        }
    }


}