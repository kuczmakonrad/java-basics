package pl.kuczdev.__code_questions.q15_arrays_find_number_occuring_odd_number_of_times_in_an_array;

import java.util.HashMap;
import java.util.Map;
/*
takes o(n) of space complexity
 */

public class NumberOccuringOddNumberInArrayByHashMap {
    public static void main(String[] args) {
        System.out.println("FIRST MINE METHOD:");
        int[] test = new int[]{20,40,50,40,50,20,30,30,50,20,40,40,20};
        System.out.println("In testArray you can see triple 50 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArray(test));
        int[] test2 = new int[]{1,2,3,4,5,1,2,3,4,5,9};
        System.out.println("In testArray2 you can see once 9 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArray(test2));
        int[] test3 = new int[]{100,100,100,100,200,200,200,200,300,300,300,300,1};
        System.out.println("In testArray3 you can see once 1 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArray(test3));

        System.out.println("SECOND BLOG METHOD:");
        int[] test4 = new int[]{20,40,50,40,50,20,30,30,50,20,40,40,20};
        System.out.println("In testArray4 you can see triple 50 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayBlogExample(test4));
        int[] test5 = new int[]{1,2,3,4,5,1,2,3,4,5,9};
        System.out.println("In testArray5 you can see once 9 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayBlogExample(test5));
        int[] test6 = new int[]{100,100,100,100,200,200,200,200,300,300,300,300,1};
        System.out.println("In testArray6 you can see once 1 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayBlogExample(test6));
    }

    private static int findNumberOccuringOddNumberInArray(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (hm.containsKey(element)) {
                hm.replace(element, (hm.get(element) + 1));
            } else {
                hm.put(element, 1);
            }
        }

        for (Integer i:hm.keySet()) {
            if (hm.get(i)%2 != 0) {
                return i;
            }
        }

        return -1;
    }

    private static int findNumberOccuringOddNumberInArrayBlogExample(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (hm.get(element)==null) {
                hm.put(element,  1);
            } else {
                hm.put(element, hm.get(element) + 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry: hm.entrySet()) {
            if (entry.getValue()%2 == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
