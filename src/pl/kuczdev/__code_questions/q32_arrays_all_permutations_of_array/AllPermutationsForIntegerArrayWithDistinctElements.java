package pl.kuczdev.__code_questions.q32_arrays_all_permutations_of_array;

import java.util.ArrayList;
import java.util.List;

/*
Given array of distinct integers, print all permutations of the array.

For example:
    array : [10, 20, 30]
    Permuations are: [10, 20, 30] [10, 30, 20] [20, 10, 30] [20, 30, 10] [30, 10, 20] [30, 20, 10]

We can solve the problem with the help of recursion. It is quite hard to explain recursion, so I have created a recursion tree to demonstrate it.
 */
public class AllPermutationsForIntegerArrayWithDistinctElements {
    public static void main(String[] args) {
        AllPermutationsForIntegerArrayWithDistinctElements pa = new AllPermutationsForIntegerArrayWithDistinctElements();

        int[] arr= {10, 20, 30};
        List<List<Integer>> permute = pa.permute(arr);

        System.out.println("Permuations of array : [10, 20, 30] are:");
        System.out.println("=========================================");
        for(List<Integer> perm:permute) {
            System.out.println(perm);
        }
    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr) {
        // Base case
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++){

                if (resultList.contains(arr[i])) {  // If element already exists in the list then skip
                    continue;
                }

                resultList.add(arr[i]);                         // Choose element
                permuteHelper(list, resultList, arr);           // Explore
                resultList.remove(resultList.size() - 1); // Unchoose element
            }
        }
    }
}