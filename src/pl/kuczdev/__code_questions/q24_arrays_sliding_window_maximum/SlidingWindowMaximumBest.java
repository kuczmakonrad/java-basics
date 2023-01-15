package pl.kuczdev.__code_questions.q24_arrays_sliding_window_maximum;

import java.util.LinkedList;
import java.util.Scanner;

/*
Most Efficient Approach:

In this approach we use Deque which helps us finding the sliding window maximum in O(n).
    A Deque is basically a queue which is open on both the ends for both enqueue and Deque, that is, you can add or remove element either from front or rear.

What we actually do to solve the problem is:
we keep the k elements of the subarrays in the reverse sorted order, We need not keep all the k elements though which we will see later in code.
    * Generate the Deque for the first k elements, keeping them sorted in reverse order so that the maximum element is at the front.
    * If the Deque is empty, add the element straightaway, else check if the incoming element is greater than the last element,
        if it is, keep popping the elements from last until the last element of the remaining Deque is greater than the incoming element.
    * We also need to remove the elements which belong to different subarray. i.e the indices in the Deque must be in the range, [i, i+k].


An element will only be removed on two conditions:
    (i) If the upcoming element is greater than the element at rear, if it, it will keep on popping the element
     until there comes a larger element at rear of remaining dequeue because we need to keep the array sorted in the reverse order.
    (ii) If the element belongs to any other subarray then there is no point in keeping it.
 */
public class SlidingWindowMaximumBest {
    static int[] sarr;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.print("arr[]: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }

        System.out.println(" }");

        int windowSize = scn.nextInt();

        solveEfficient(arr, windowSize);

    }

    public static void solveEfficient(int[] arr, int k) {
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            /* keep removing the elements from deque
             * which are smaller than the current element,
             * because we need to keep our deque sorted in dec order
             */
            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
                deque.removeLast();
            }

            /* removing the i-k element, because that element does not belong
             * to the subarray we are currently working on.
             */
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            deque.addLast(i);

            if(i >= k-1)
            {
                /* only print when we have processed atleast k elements
                 * to make the very first subarray
                 */
                System.out.print(" "+arr[deque.getFirst()]);
            }

        }
    }
}