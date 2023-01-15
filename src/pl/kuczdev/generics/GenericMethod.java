package pl.kuczdev.generics;

import java.util.ArrayList;

class Util {
    public static <T> T getLastElement(ArrayList<T> list) {
        return list.get(list.size() - 1);
    }
}

class GenericsMethod {
    public static void main(String args[]) {
        ArrayList <String> arr = new ArrayList<>();
        arr.add("Ford");
        arr.add("Opel");
        arr.add("Porsche");

        System.out.println(Util.getLastElement(arr));       // OUTPUT: Porsche
    }
}
