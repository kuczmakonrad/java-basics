package pl.kuczdev.__code_questions.q22_arrays_sort_array_with_zero_one_two_values;

import java.util.Arrays;
import java.util.HashMap;

public class ArraySortExample {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2, 0, 0, 1, 2, 2, 1};
        sortArrayFirstMethod(arr);
        System.out.println("arr[] = {1, 2, 2, 0, 0, 1, 2, 2, 1} after sorting looks like: " + Arrays.toString(arr));

        int[] arr2 = new int[] {1, 2, 2, 0, 0, 1, 2, 2, 1};
        sortSecondMethod(arr2);
        System.out.println("arr[] = {1, 2, 2, 0, 0, 1, 2, 2, 1} after sorting looks like: " + Arrays.toString(arr2));
    }
/*
APPROACH – I :
A very basic approach to solve this problem can be keeping the count of number of zeroes,
ones and twos in the given array and then manipulate the given array in accordance with the frequency of every number.
This approach is a bit inspired by counting sort. No matter what the initial value of that particular index is,
we first put all the zeroes we have in the array starting from index zero, then put all the ones and after that put all the twos.

Steps:
1.) Traverse the given array once and keep incrementing the count of the number encountered.
2.) Now Traverse the array again starting from index zero
and keep changing the value of the element on current index first exhaust all the zeroes then ones and finally all the twos.

This way we have a sorted array where all the zeroes are in starting followed by all the ones and then in last section we have all the twos
in a time complexity of O(n).

But the major drawback of this approach is, we have to traverse the given array twice once for counting the number of zeroes,
ones and twos and second one for manipulating the array to make it sorted, which can be done only in a single pass.


 */
    private static void sortArrayFirstMethod(int[] arr) {
        int freq[] = new int[3]; // array to keep the count of 0s, 1s, 2s

        // traverse the given array for filling the frequency array
        for (int val : arr) {
            freq[val]++;
        }
        //System.out.println(Arrays.toString(freq));
        int pointer = 0; // pointer to traverse the given array again

        for (int i = 0; i < freq.length; i++) {

            while(freq[i]-->0) {    // loop to exhaust the number of 0s, 1s, 2s
                arr[pointer]=i;     // at the current pointer plot the current number
                pointer++;          // increment the pointer
            }
        }
    }


    /*

APPROACH – II :
This algorithm is called as Dutch national flag algorithm or Three way partitioning in which elements of similar type are grouped together
and their collective groups are also sorted in a the correct order.
Now we have three types of elements to be sorted, therefore, we divide the given array in four sections out of which 3 sections are designated to zeroes,
Ones and twos respectively and one section is unknown or the section which is left to be explored.
Now for traversing in these sections we need 3 pointers as well which will virtually divide the given array in four segments.
Let us name these pointers as low, mid and high.
Now we can tell the starting and ending points of these segments.

Segment-1 : zeroes
This will be a known section containing only zeroes with a range of [0, low-1].
Segment-2: Ones
This will also be a know section containing only ones with a range of [low, mid-1].
Segment-3 : Unexplored
This will be an unknown section as the elements in this sections are yet to be explored and hence it can contain all types of element that is,
zeroes, ones and twos. Range of this segment will be [mid, high]
Segment-4 : Twos
This will be the last and known area containing only twos having the range of [high+1, N] where N is the length of the given array or basically
the last valid index of the given array.

Steps used in this Algorithm to sort the given array in a single pass:

(i) Initialize the low, mid and high pointers to, low = 0, mid = 0, high = N

(ii) Now, run a loop and do the following until the mid pointer finally meets high pointer.
As the mid pointer moves forward we keep putting the element at mid pointer to its right position by swapping that element with the element at pointers
of respective sections.

    (iii) CASE – I : If the element at mid, that is, A[mid] == 0, this means the correct position of this element is in the range [0, low-1],
    therefore, we swap A[mid] with A[low] and increment low making sure that element with index lesser than low is a Zero.

    (iv) CASE – II : If the element at mid, that is, A[mid] == 2, this means the correct position of this element is in the range [hi+1, N],
     therefore, we swap A[mid] with A[hi] and decrement high making sure that element with index greater than high is a two.

    (v) CASE – III : If the element at mid, that is, A[mid]=1, this means that the element is already in its correct segment because [low, mid-1]
    is the range where it needs to be. Therefore, we do nothing and simply increment the mid pointer.

So, there are total three cases, let us take a moment and emphasise on the fact that mid pointer gets only incremented only when the element A[mid] == 1.
Let us discuss every case individually,

For case – I : In this case we increment mid as well along with increment low pointer, as we are sure that element at low pointer before swapping
can surely only be one as had it been a two, it would have already got swapped with high pointer when mid pointer explored it as the only reason
that mid pointer left it because it was a one.

For case – II : Now, In this case we swap the element at mid and high, but unlike case – I,
in this case we are not sure about the element which will come at mid index after swapping as the element at high index before swapping can be any of zero,
one or two, therefore, we need to explore this swapped element and hence we do not increment mid pointer in this case.

For case – III : There is no confusion regarding incrementing mid in this case as already discussed,
 as we know the element at mid is one therefore we definitely need to increment mid here.

Time complexity of this algorithm is also O(n) but it sorts the array in just a single pass and without any extra space unlike previous approach.
*/
    public static void sortSecondMethod(int[]a)
    {
        /* Three pointers to divide the array in designated segments as discussed in the post*/
        int low=0,mid=0,high=a.length-1;
        while(mid<=high)
        {
            /* Case - 1, when element at mid pointer is zero, swap with element at low*/
            if(a[mid]==0)
            {
                a[low]=swap(a[mid], a[mid]=a[low]);
                /* Increment low as well as mid, as we know the swapped element at mid is a one*/
                low++;
                mid++;
            }
            /* Case - 1, when element at mid pointer is two, swap with element at high*/
            else if(a[mid]==2)
            {
                /* decrement only high and keep mid unchanged, as we do not know anything about the swapped element at mid*/
                a[high]=swap(a[mid],a[mid]=a[high]);
                high--;
            }
            else {
                /*Case - 3, when element at mid pointer is one do nothing, and increment mid pointer*/
                mid++;
            }

        }
    }

    /* utility swap function*/
    public static int swap(int i, int j)
    {
        return i;
    }

}
