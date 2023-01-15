package pl.kuczdev.__code_questions.q35_arrays_maximum_difference_between_two_elements_in_array;
/*
Given array of integers, find Maximum difference between two elements such that larger element appears after the smaller number
For example:
    int arr[]={14, 12, 70, 15, 95, 65, 22, 30};
    Max Difference =95-12 = 83

Algorithm:
    Lets say we have array arr[] of stock prices.
    We will track two variable :minElementTillNow and maxDifference.
        * minElementTillNow will be initialise to arr[0].
        * Iterate over  arr[]
        * If current element is greater than minElementTillNow
            ** calculate difference.
            ** If difference is greater than maxDifference then update the maxDifference.
        * If current element is lesser than minElementTillNow
            ** update minElementTillNow with current element.
        * We will get maxDifference in the end.
 */
public class MaximumDifferenceBetweenTwoElementsInArray {
    public static void main(String[] args) {
        int arr[] = {14, 12, 70, 15, 95, 65, 22, 30};
        System.out.println("Maximum difference between two elements : " + calculateMaxDifferenceBetweenTwoElements(arr));
    }

    private static int calculateMaxDifferenceBetweenTwoElements(int[] arr) {
        int minElementTillNow = arr[0];
        int difference = 0;
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minElementTillNow) {
                difference = arr[i] - minElementTillNow;
                if (difference > maxDifference) {
                    maxDifference = difference;
                }
            } else {
                minElementTillNow = arr[i];
            }
        }

        return maxDifference;
    }
}
