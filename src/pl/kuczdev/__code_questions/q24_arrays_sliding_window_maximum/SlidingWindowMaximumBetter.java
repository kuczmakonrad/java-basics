package pl.kuczdev.__code_questions.q24_arrays_sliding_window_maximum;

import java.util.Scanner;
/*
Slightly Efficient Approach:

We can surely reduce the time taken in finding max for every subarray by using Segment tree.
We can Implement a segment tree for the given array, and we can get the max of every subarray with range query [i, i+k-1].

Total number of nodes in segment tree :
The worst time complexity for constructing the segment tree would be O(n) because we know,
(i) Leaf nodes of segment tree contains all the elements of the array.
(ii) The number of nodes on last level is the number of nodes on all the upper levels.

Mathematically,
1. Consider length of the array to be n, therefore, leaf nodes of the segment tree will be n.
2. hence, the number of nodes on all the upper levels will be n-1.
3. Total nodes on segment tree for an array of length n will be:
        Tn = leaf nodes + nodes on upper levels
              = n + n-1
              = 2n+1

Complexity Analysis
The construction of our segment tree involves calculation for every node only once, so worst time complexity of construction of segment tree
will be O(2n+1) i.e O(n).
and result for range query of each subarray will be calculate in O(logk).
The query calculation will be done for all the ‘n-k+1’ subarrays of size k.
therefore overall time complexity for this algorithm will be O((n-k+1)*logk) i.e. O(nlogk).
 */
public class SlidingWindowMaximumBetter {
    static int[] sarr;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int windowSize = scn.nextInt();

        int height = (int)Math.ceil((Math.log(arr.length) / Math.log(2)));

        /* size of segment array  i.e. the number of nodes will be = [(2^height+1)-1] */

        sarr = new int[1<<height -1];

        construct(0, 0, arr.length-1, arr);

        solve(arr, windowSize);

    }

    public static void solve(int[] arr, int k) {
        for (int i = 0; i <= arr.length - k; i++) {
            /* finding the result for range query from i to i+k which is basically a subarray.
             *
             */
            System.out.println(query(0, i, i + k - 1, 0, arr.length - 1));
        }
    }

    public static int construct(int idx, int start, int end, int[] arr) {
        /* leaf nodes contains the array elements */
        if (start == end) {
            sarr[idx] = arr[end];
            return sarr[idx];
        }

        int mid = (start + end) / 2;
        /* dividing the range for every node in segment tree into two halves */
        int left = construct(2 * idx + 1, start, mid, arr);
        int right = construct(2 * idx + 2, mid + 1, end, arr);
        /* result for current index in segment tree will be calculated
         *  in post order, and will be maximum of its two childs.
         */
        sarr[idx] = Math.max(left, right);
        return sarr[idx];
    }

    public static int query(int idx, int queryStart, int QueryEnd, int start, int end) {
        /* if our range is completely outside the query,
         * we need to return a result such that it causes no effect in our final answer.
         */

        if (start > QueryEnd || end < queryStart) {
            return Integer.MIN_VALUE;
        }
        /* if the range of the current segment falls completely
         *  inside the query then return its value.
         */
        else if (start >= queryStart && end <= QueryEnd) {
            return sarr[idx];
        } else {

            int mid = (start + end) / 2;
            int left = query(2 * idx + 1, queryStart, QueryEnd, start, mid);
            int right = query(2 * idx + 2, queryStart, QueryEnd, mid + 1, end);

            return Math.max(left, right);
        }
    }
}