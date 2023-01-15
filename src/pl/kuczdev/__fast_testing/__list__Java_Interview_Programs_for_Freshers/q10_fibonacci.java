package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

public class q10_fibonacci {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Print fibonacci till " + num + " element:");
        printFibbonaciTillArgument(num);
    }

    private static void printFibbonaciTillArgument(int num) {
        String result = "0 1";
        int first = 0;
        int second = 1;
        int current;

        for (int i = 2; i <= num-1; i++) {
            current = first + second;
            result += " " + current;
            first = second;
            second = current;
        }

        System.out.println(result);
    }


}
