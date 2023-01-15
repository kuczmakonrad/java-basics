package pl.kuczdev.lambda;

// interfejs funkcyjny
interface Addition {
    int add(int a, int b);
}

// interfejs funkcyjny
interface MathOperation <T>{
    T operate(T a, T b);
}

public class LambdaBasics {
    public void test(Addition addition) {
        System.out.println(addition.add(2, 5));
    }

    public static void main(String[] args) {
        Addition addition = (int a, int b) -> a + b;
        System.out.println(addition.add(100,200));      // OUTPUT: 300
        System.out.println(addition.add(105,203));      // OUTPUT: 308

        LambdaBasics lambdaBasics = new LambdaBasics();       // Takie wyrażenie (lambdy) możemy przekazać jako argument do jakiejś metody np.
        lambdaBasics.test(addition);                          // OUTPUT: 7

        lambdaBasics.test( (int a, int b) ->  a * 2 + b );            // Możemy również przekazać kolejne wyrażenie lambda do parametru. OUTPUT: 9

        MathOperation<Float> addition2 = (a, b) -> a + b;
        System.out.println(addition2.operate(10.0f, 300.0f));         // OUTPUT: 310.0

        MathOperation<Integer> substraction = (a, b) -> a - b;
        System.out.println(substraction.operate(100, 77));            // OUTPUT: 23.0
    }
}
