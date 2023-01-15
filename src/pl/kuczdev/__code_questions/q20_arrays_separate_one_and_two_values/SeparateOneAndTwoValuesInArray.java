package pl.kuczdev.__code_questions.q20_arrays_separate_one_and_two_values;

import java.util.Arrays;

public class SeparateOneAndTwoValuesInArray {
    public static void main(String[] args) {
        int [] arr = new int [] {0,1,0,0,1,1,1,0,1,1};
        System.out.println("Array = " + Arrays.toString(arr) + ", after sorting: " + Arrays.toString(firstMethodByMe(arr)));
        System.out.println("Array = " + Arrays.toString(arr) + ", after sorting: " + Arrays.toString(secondMethodByMe(arr)));
        System.out.println("Array = " + Arrays.toString(arr) + ", after sorting: " + Arrays.toString(firstMethodByBlog(arr)));
        System.out.println("Array = " + Arrays.toString(arr) + ", after sorting: " + Arrays.toString(secondMethodByBlog(arr)));

    }

    private static int[] firstMethodByMe(int[] array) {
        int[] result = new int[array.length];
        int l = 0;
        int r = array.length-1;

        for(int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                result[r] = 1;
                r--;
            } else {
                result[l] = 0;
                l++;
            }
        }
        return result;
    }
    private static int[] secondMethodByMe(int[] array) {
        Arrays.sort(array);
        return array;
    }

    private static int[] firstMethodByBlog(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int left=0;
            int right=array.length-1;
            while(array[left]==0) {
                left++;
            }
            while(array[right]==1) {
                right--;
            }

            if(left<right) {
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        return array;
    }

    private static int[] secondMethodByBlog(int arr[]) {
        int count = 0;
        // zliczam zera
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) count++;
        }

        // ustawiam zera od lewej (tyle ile zliczonych)
        for (int i = 0; i < count; i++) {
            arr[i]=0;
        }
        // w resztę pól ustawiam jedynki
        for (int i = count; i < arr.length; i++) {
            arr[i]=1;
        }
        // zwracam liste
        return arr;
    }
}
