package pl.kuczdev.lambda;

import java.util.function.IntSupplier;

/*
@FunctionalInterface
public interface IntSupplier {
    int getAsInt();
}
*/

public class MethodReference {
    public void test(IntSupplier intSupplier) {
        System.out.println(intSupplier.getAsInt());
    }

    public static void main(String[] args) {
        Object obj = new Object();
        IntSupplier intSuppier = obj::hashCode;

        int hash = intSuppier.getAsInt();
        System.out.println(hash);
        System.out.println(hash == obj.hashCode());

        MethodReference methodReference = new MethodReference();
        methodReference.test(intSuppier);
    }
}
