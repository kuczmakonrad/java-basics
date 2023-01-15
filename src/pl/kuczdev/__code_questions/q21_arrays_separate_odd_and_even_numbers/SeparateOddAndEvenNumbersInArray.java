package pl.kuczdev.__code_questions.q21_arrays_separate_odd_and_even_numbers;

import java.util.Arrays;
/*
Initialise two index variable , left=0 and right=arr.length-1
Increment left variable until you get odd number
Decrement right variable until you get even number.
If left < right, swap arr[left] and arr[right]
In the end, you will see that you have even numbers on left side and odd numbers on right side.
 */
public class SeparateOddAndEvenNumbersInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {12, 17, 70, 15, 22, 65, 21, 90};
        System.out.println("Array = " + Arrays.toString(arr) + ", after even and odd sort looks like = " + Arrays.toString(separateOddAndEvenNumbersByMe(arr)));
        System.out.println("Array = " + Arrays.toString(arr) + ", after even and odd sort looks like = " + Arrays.toString(separateOddAndEvenNumbersByBlog(arr)));

    }

    private static int[] separateOddAndEvenNumbersByMe(int[] arr) {
        int[] result = new int[arr.length];
        int oddIndex = 0;
        int evenIndex = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0) {
                result[oddIndex] = arr[i];
                oddIndex++;
            } else {
                result[evenIndex] = arr[i];
                evenIndex--;
            }
        }
        return result;
    }
    /*
    Initialise two index variable , left=0 and right=arr.length-1
Increment left variable until you get odd number
Decrement right variable until you get even number.
If left < right, swap arr[left] and arr[right]
In the end, you will see that you have even numbers on left side and odd numbers on right side.
     */

    private static int[] separateOddAndEvenNumbersByBlog(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        for (int i = 0; i < arr.length; i++) {
            while(arr[left]%2 == 0) {
                left++;
            }

            while (arr[right]%2 == 1) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }


}
