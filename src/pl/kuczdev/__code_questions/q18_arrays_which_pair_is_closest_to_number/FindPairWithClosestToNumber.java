package pl.kuczdev.__code_questions.q18_arrays_which_pair_is_closest_to_number;

// Time complexity : O(NLogN)
public class FindPairWithClosestToNumber {
    public static void main(String[] args) {
        int array[]= {-40,-5,1,3,6,7,8,20};
        findPairWithClosestToNumberBruteForce(array,5);
        findPairWithClosestToNumber(array,5);
    }

    // 1 SOLUTION: You can check each and every pair of numbers and find the sum close to X.
    public static void findPairWithClosestToNumberBruteForce(int arr[],int X) {
        if(arr.length<2)
            return;
        // Suppose 1st two element has minimum diff with X
        int minimumDiff=Math.abs(arr[0]+arr[1]-X);
        int pair1stIndex=0;
        int pair2ndIndex=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int tempDiff=Math.abs(arr[i]+arr[j]-X);

                if(tempDiff < minimumDiff) {
                    pair1stIndex=i;
                    pair2ndIndex=j;
                    minimumDiff=tempDiff;
                }
            }
        }
        System.out.println(" The pair whose sum is closest to X using brute force method: "+arr[pair1stIndex]+" "+ arr[pair2ndIndex]);

    }

    /*  2 SOLUTION:
        1. We will maintain two indexes one at beginning (l=0) and one at end (r=n-1)
        2. iterate until l <  r
        3. Calculate diff as arr[l] + arr[r]-x
        4. if abs (diff) < minDiff then update the minimum sum and pair.
        5. If arr[l] + arr[r] is less than X, this means if we want to find sum close to X, do r–
        6. If arr[l] + arr[r] is greater than 0,this means if we want to find sum close to X , do l++
     */
    public static void findPairWithClosestToNumber (int arr[],int X) {
        int minimumDiff = Integer.MAX_VALUE;
        int n = arr.length;

        if (n < 0) return;

        int l = 0;      // left index variable
        int r = n-1;    // right index variable


        // variable to keep track of the left and right pair for minimumSum
        int minLeft = l;
        int minRight = n-1;

        while (l < r) {
            int currentDiff = Math.abs(arr[l] + arr[r] - X);

            if(currentDiff < minimumDiff) {
                minimumDiff = currentDiff;
                minLeft = l;
                minRight = r;
            }

            if (arr[l]+ arr[r] < X)
                l++;
            else
                r--;
        }

        System.out.println("The pair whose sum is closest to X: " + arr[minLeft] + " " + arr[minRight]);
    }
}
