package pl.kuczdev.__code_questions.q33_arrays_rotate_array_by_k_positions;
/*
Problem:
    N=6 and k=2
    If Arr[] = {1, 2, 3, 4, 5, 6} and k = 2
    then will be  {5, 6, 1, 2, 3, 4}

SOLUTION 1:
    Move each number by 1 place and do it k times.
    Time complexity: o(n*k).
    Where n is number of elements and k denotes position shift.
    Space complexity: o(1).

SOLUTION 2:
    You can rotate the array using temp array in o(n).
    Time complexity: o(n).
    Space complexity: o(n).

SOLUTION 3:
This is the most optimized approach.
Algorithm for this approach works as below:
    1. Reverse whole array.
    2. Reverse first k elements
    3. Reverse rest n-k elements.

For example:
    let’s say Array is {1,2,3,4,5,6,7,8}
    You want to rotate by k position.
    It will work as below:
        You rotate the whole array. So array became: {8,7,6,5,4,3,2,1}
        Reverse first k elements, so array became : {7,8,6,5,4,3,2,1}
        Reverse rest of elements, so array became  : {7,8,1,2,3,4,5,6}
*/

public class RotateArrayByKPositionsThreeWays {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8};

        System.out.println("Rotate array by shifting one elements by 1 and do it k times");
        int[] result1 = rotateBruteForce(nums,2);
        System.out.println("Final rotated array :");
        printArray(result1);
        System.out.println();
        System.out.println("================================");
        System.out.println("Rotate array using extra space");

        int nums2[] = {10,20,30,40,50,60};
        int[] result2 = rotateExtraSpace(nums2,5);
        printArray(result2);
        System.out.println();
        System.out.println("================================");
        System.out.println("Rotate array most optimized approach");
        int nums3[] = {1,2,3,4,5,6,7,8,9,10};
        int[] result3 = rotateOptimized(nums3,4);
        printArray(result3);
    }

    public static int[] rotateBruteForce(int[] nums, int k) {
        int n=nums.length;
        if(k > n)
            k = k % n;
        for (int i = 0; i < k; i++) {
            for (int j = n-1; j > 0; j--) {
                // move each number by 1 place
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
            System.out.println("Array rotation after " + (i+1) + " step");
            printArray(nums);
            System.out.println();
        }
        return nums;
    }

    public static int[] rotateExtraSpace(int[] nums, int k) {
        int n = nums.length;
        if(k > n) k = k % n;

        int[] result = new int[n];

        for(int i = 0; i < k; i++) {
            result[i] = nums[n-k+i];
        }

        int index=0;
        for(int i = k; i < n; i++) {
            result[i] = nums[index++];
        }
        return result;
    }

    public static int[] rotateOptimized(int[] nums, int k) {
        int n = nums.length;
        if(k > n) k=k%n;

        nums=reverse(nums,0,n-1);
        nums=reverse(nums,0,k-1);
        nums=reverse(nums,k,n-1);
        return nums;
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

