package pl.kuczdev.__fast_testing.fast_fibbonnaci_test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("FIRST METHOD:");
        long t1 = System.nanoTime();
        System.out.println("5 element (result should be 5), result = " + getFibbonnaciElementByList(5));
        System.out.println("10 element (result should be 55), result = " + getFibbonnaciElementByList(10));
        System.out.println("15 element (result should be 610), result = " + getFibbonnaciElementByList(15));
        System.out.println("17 element (result should be 1597), result = " + getFibbonnaciElementByList(17));
        System.out.println("19 element (result should be 4181), result = " + getFibbonnaciElementByList(19));
        System.out.println("40 element (result should be 102334155), result = " + getFibbonnaciElementByList(40));
        System.out.println("50 element (result should be 12586269025), result = " + getFibbonnaciElementByList(50));
        System.out.println("100 element (result should be 3736710778780434371), result = " + getFibbonnaciElementByList(100));
        System.out.println("150 element (result should be 3736710778780434371), result = " + getFibbonnaciElementByList(150));
        //System.out.println("1000 element (result should be ), result = " + getFibbonnaciElementByList(1000));

        for (int i = 0; i < 100; i++) {
            System.out.println(getFibbonnaciElementByList(i));
        }

        long t2 = System.nanoTime();
        System.out.println("FIRST METHOD TIME: " + (t2-t1) );

        System.out.println("---------------------------------------------------------------------------------------------------");

        System.out.println("SECOND METHOD:");
        long t3 = System.nanoTime();
        System.out.println("5 element (result should be 5), result = " + getFibbonnaciElementByArray(5));
        System.out.println("10 element (result should be 55), result = " + getFibbonnaciElementByArray(10));
        System.out.println("15 element (result should be 610), result = " + getFibbonnaciElementByArray(15));
        System.out.println("17 element (result should be 1597), result = " + getFibbonnaciElementByArray(17));
        System.out.println("19 element (result should be 4181), result = " + getFibbonnaciElementByArray(19));
        System.out.println("40 element (result should be 102334155), result = " + getFibbonnaciElementByArray(40));
        System.out.println("50 element (result should be 12586269025), result = " + getFibbonnaciElementByArray(50));
        System.out.println("100 element (result should be 3736710778780434371), result = " + getFibbonnaciElementByArray(100));
        System.out.println("150 element (result should be 3736710778780434371), result = " + getFibbonnaciElementByArray(150));
        //System.out.println("1000 element (result should be ), result = " + getFibbonnaciElementByArray(1000));

        for (int i = 0; i < 100; i++) {
            System.out.println(getFibbonnaciElementByList(i));
        }

        long t4 = System.nanoTime();
        System.out.println("SECOND METHOD TIME: " + (t4-t3));
    }

    private static Long getFibbonnaciElementByList(int element) {
        List<Long> fibList = new ArrayList<>(element);
        fibList.add(0L);
        fibList.add(1L);
        fibList.add(1L);

        if (element == 0 || element == 1 || element == 2) {
            return fibList.get(element);
        }

        int counter = 3;
        while (counter <= element) {
            Long result = fibList.get(counter-2) + fibList.get(counter-1);
            fibList.add(counter, result);
            counter++;
        }

        return fibList.get(element);
    }

    private static long getFibbonnaciElementByArray(int element) {
        long[] fibList = new long[element+1];
        fibList[0] = 0L;
        fibList[1] = 1L;
        fibList[2] = 1L;

        if (element == 0 || element == 1 || element == 2) {
            return fibList[element];
        }

        for (int i = 3; i <= element; i++) {
            fibList[i] = fibList[i-2] + fibList[i-1];
        }

        return fibList[element];
    }
}