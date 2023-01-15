package pl.kuczdev.__code_questions.q40_arrays_find_all_subsets_of_power_set;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, arr, return all possible subsets (the power set).

Input: nums = [1,2,3] Output:
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]

We will use two approaches here.
    Using recursion
        You can find all subsets of set or power set using recursion. Here is the simple approach.
            * As each recursion call will represent subset here, we will add resultList(see recursion code below) to the list of subsets in each call.
            * Iterate over elements of a set.
            * In each iteration
                * Add elements to the list
                * explore(recursion) and make start = i+1 to go through remaining elements of the array.
                * Remove element from the list.
 */
public class FindAllSubsetsOfPowerSetRecursion {
    public static void main(String[] args) {
        FindAllSubsetsOfPowerSetRecursion soa = new FindAllSubsetsOfPowerSetRecursion();
        int[] nums = {1, 2, 1};
        List<List<Integer>> subsets = soa.subsets(nums);

        for (List<Integer> subset: subsets) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length; i++){
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }
}
