package pl.kuczdev.__work_questions.overload_overwrite;

public class OverloadingExample {
    public static int add(int a, int b) {
        System.out.println("");
        System.out.print("THIS IS 1 OVERLOAD METHOD! RESULT = ");
        return a + b;
    }
    public static int add(int a, int b, int c) {
        System.out.println("");
        System.out.print("THIS IS 2 OVERLOAD METHOD! RESULT = ");
        return a + b + c;
    }
    public static int add(int a, int b, int c, int d) {
        System.out.println("");
        System.out.print("THIS IS 3 OVERLOAD METHOD! RESULT = ");
        return a + b + c + d;
    }

    public static double add(double a, double b) {
        System.out.println("");
        System.out.print("THIS IS 4 OVERLOAD METHOD! RESULT = ");
        return a + b;
    }
    public static double add(double a, double b, double c) {
        System.out.println("");
        System.out.print("THIS IS 5 OVERLOAD METHOD! RESULT = ");
        return a + b + c;
    }
    public static double add(double a, double b, double c, double d) {
        System.out.println("");
        System.out.print("THIS IS 6 OVERLOAD METHOD! RESULT = ");
        return a + b + c + d;
    }

    public static void main(String[] args) {
        System.out.println("INTEGER OVERRIDE METHODS:");
        System.out.println(OverloadingExample.add(10, 100));
        System.out.println(OverloadingExample.add(1, 2, 3));
        System.out.println(OverloadingExample.add(100, 200, 300, 400));
        System.out.println("\n\nDOUBLE OVERRIDE METHODS:");
        System.out.println(OverloadingExample.add(10.2, 100.2));
        System.out.println(OverloadingExample.add(1.2, 2.2, 3.2));
        System.out.println(OverloadingExample.add(100.2, 200.2, 300.2, 400.2));

        int aa=1;
        int bb=2;
        int cc=3;
        OverloadingExample.add(aa,bb,cc);
    }
}
