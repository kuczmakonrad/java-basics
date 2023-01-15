package pl.kuczdev.__code_questions.q16_arrays_find_minimum_number_of_platforms_required_railway_station;

import java.util.Arrays;

/*
You are given a array of integer.
All numbers occur even number of times except one.
You need to find the number which occurs odd number of time.
You need to solve it with o(n) time complexity and o(1) space complexity.

For example:
    int array[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
    Number which occurs odd number of times is : 50

 Solution 1:
    You can iterate over all intervals and check how many other intervals are overlapping with it but that will require o(N^2) time complexity.
 Solution 2:
    We will use logic very much similar to merge sort.
        1. Sort both arrival(arr) and departure(dep) arrays.
        2. Compare current element in arrival and departure array and pick smaller one among both.
        3. If element is pick up from arrival array then increment platform_needed.
        4. If element is pick up from departure array then decrement platform_needed.
        5. While performing above steps, we need track count of maximum value reached for platform_needed.
        6. In the end, we will return maximum value reached for platform_needed.
    Time complexity : O(NLogN)
 */
public class MinimumNumbersOfPlatformsRailwayStation {
    public static void main(String[] args) {
        // arr[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
        // dep[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
        int arr[] = {100, 140, 150, 200, 215, 400};
        int dep[] = {110, 300, 210, 230,315, 600};
        System.out.println("Minimum platforms needed:" + findPlatformsRequiredForStationSecondSolution(arr,dep,6));

    }

    // arr[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
    // dep[] = {1:10, 2:20, 2:30, 3:00, 3:15, 6:00}
    static int findPlatformsRequiredForStationSecondSolution(int arr[], int dep[], int n) {
        int platform_needed = 0, maxPlatforms = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;

        // Similar to merge in merge sort
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                platform_needed++;
                i++;
                if (platform_needed > maxPlatforms)
                    maxPlatforms = platform_needed;
            } else {
                platform_needed--;
                j++;
            }
        }
        return maxPlatforms;
    }
}