package pl.kuczdev.__code_questions.q40_arrays_find_all_subsets_of_power_set;
/*
You can find all subsets of set or power set using iteration as well.

There will be 2^N subsets for a given set, where N is the number of elements in set.
For example, there will be 2^4 = 16 subsets for the set {1, 2, 3, 4}.

Each ‘1’ in the binary representation indicate an element in that position.
For example, the binary representation of number 6 is 0101 which in turn represents the subset {1, 3} of the set {1, 2, 3, 4}.

You can find all subsets of set or power set using iteration as well.

There will be 2^N subsets for a given set, where N is the number of elements in set.
For example, there will be 2^4 = 16 subsets for the set {1, 2, 3, 4}.

Each ‘1’ in the binary representation indicate an element in that position.
For example, the binary representation of number 6 is 0101 which in turn represents the subset {1, 3} of the set {1, 2, 3, 4}.

How can we find out which bit is set for binary representation, so that we can include the element in the subset?
    To check if 0th bit is set, you can do logical & with 1
    To check if 1st bit is set, you can do logical & with 2
    To check if 2nd bit is set, you can do logical & with 2^2

Let’s say with the help of example:

For a set {1 ,2, 3}
0 1 1  &  0 0 1 = 1    –> 1 will be included in subset
0 1 1  &  0 1 0 = 1    –> 2 will be included in subset
0 1 1  &  1 0  0 =0    –> 3 will not be included in subset.
 */
public class FindAllSubsetsOfPowerSetBitManipulation {
    static void printSubsets(int set[]) {
        int n = set.length;
        // Run a loop from 0 to 2^n
        for (int i = 0; i < (1<<n); i++) {
            System.out.print("{ ");
            int m = 1; // m is used to check set bit in binary representation.
            // Print current subset
            for (int j = 0; j < n; j++) {
                if ((i & m) > 0) {
                    System.out.print(set[j] + " ");
                }
                m = m << 1;
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int set[] = {1 ,2, 3};
        printSubsets(set);
    }
}