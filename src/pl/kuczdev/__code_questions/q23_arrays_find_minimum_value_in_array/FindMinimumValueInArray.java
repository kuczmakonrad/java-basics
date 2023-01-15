package pl.kuczdev.__code_questions.q23_arrays_find_minimum_value_in_array;

public class FindMinimumValueInArray {
    public static void main(String[] args) {
        int [] arr1 = new int[] {10, 5, 3, 6, 13, 16, 7};
        System.out.println("arr = {10, 5, 3, 6, 13, 16, 7} result should be 3, minimum value = " + getMinimumValueInArray(arr1));

        int [] arr2 = new int[]{11,12,13,14};
        System.out.println("arr = {11,12,13,14} result should be 11, minimum value = " + getMinimumValueInArray(arr2));

        int [] arr3 = new int[]{10};
        System.out.println("arr = {10} result should be 10, minimum value = " + getMinimumValueInArray(arr3));

        int [] arr4 = new int[]{8,6};
        System.out.println("arr = {8,6} result should be 6, minimum value = " + getMinimumValueInArray(arr4));
    }

    private static int getMinimumValueInArray(int[] arr) {
        int highest = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (highest > arr[i]) {
                result = arr[i];
                highest = arr[i];
            }
        }

        return result;
    }
}
