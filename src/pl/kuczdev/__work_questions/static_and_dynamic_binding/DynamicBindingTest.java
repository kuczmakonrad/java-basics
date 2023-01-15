package pl.kuczdev.__work_questions.static_and_dynamic_binding;
/*
1) Wiązanie statyczne w Javie występuje w czasie kompilacji , a wiązanie dynamiczne w czasie wykonywania
2) Prywatne , finalne i statyczne metody i zmienne używają statycznego wiązania i są wiązane przez kompilator.
   Podczas gdy metody wirtualne są wiązane w czasie wykonywania na podstawie obiektu runtime.
3) Wiązanie statyczne wykorzystuje informacje Type (klasa w javie)  do wiązania, podczas gdy wiązanie dynamiczne używa obiektu do rozwiązania wiązania.
Czyli wiązanie statyczne uważa za ważniejszą lewą stronę (typ zmiennej), a wiązanie dynamiczne prawą stronę (czyli obiekt).

In this section, we will see an example of dynamic binding in java which occurs during run time and instead of Type or Class information,
Object is used to resolve method calls.

OUTPUT: Car launch!

In this example of Dynamic Binding, we have used the concept of method overriding.
Car extends Vehicle and overrides its start() method and when we call start() method from a reference variable of type Vehicle,
it doesn't call start() method from Vehicle class instead it calls start() method from Car subclass because object referenced by Vehicle type is a Car object.

This resolution happens only at runtime because objects are only created during runtime and are called dynamic binding in Java.
Dynamic binding is slower than static binding because it occurs in runtime and spends some time to find out the actual method to be called.

That's all on the difference between static and dynamic binding in java. The bottom line is static binding is a compile-time operation
while the dynamic binding is a runtime. one uses Type and the other uses Object to bind.

static, private, and final methods and variables are resolved using static binding which makes their execution fast
because no time is wasted to find the correct method during runtime.
 */

class Vehicle {
    public void start() {
        System.out.println("Vehicle launch!");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car launch!");
    }
}

public class DynamicBindingTest {
    public static void main(String args[]) {
        Vehicle vehicle = new Car();    // here Type is vehicle but object will be Car
        vehicle.start();                //Car's start called because start() is overridden method
    }
}