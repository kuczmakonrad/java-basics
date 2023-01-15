package pl.kuczdev.__code_questions.q28_arrays_find_leaders_in_array;
// Time complexity : o(N^2)
// Use two loops. Outer loop to iterate over array elements and inner loop to check for right elements of the array.
// If current element is greater than right elements than it is a leader.

public class FindLeadersInArrayUsingTwoLoops {
    public static void main(String[] args) {
        int arr[]={14, 12, 70, 15, 99, 65, 21, 90};
        findLeadersInAnArrayBruteForce(arr);
    }

    public static void findLeadersInAnArrayBruteForce(int arr[]) {
        System.out.println("Finding leaders in an array using brute force : ");
        for (int i = 0; i < arr.length; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) System.out.print(arr[i] + " ");
        }
    }
}
