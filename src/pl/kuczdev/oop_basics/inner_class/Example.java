package pl.kuczdev.oop_basics.inner_class;

class SomeExample {
    // prywatna klasa w klasie
    private class PrivClass {
        public void printInfo() {
            System.out.println("Message from privClass!");
        }
    }

    // publiczna klasa w klasie
    public class PubClass {
        public void printInfo() {
            System.out.println("Message from pubClass!");
        }
    }

    // metoda używająca prywatnej klasy
    public void run() {
        PrivClass privClass = new PrivClass();
        privClass.printInfo();

        // nowa klasa w metodzie
        class InnerClass {
            public void printInfo() {
                System.out.println("Message from innerClass!");
            }
        }

        // użycie powyższej klasy z metody (tylko w obrębie metody poprzez modyfikator dostępu)
        InnerClass innerClass = new InnerClass();
        innerClass.printInfo();
    }
}

public class Example {
    public static void main(String[] args) {
        SomeExample someExample = new SomeExample();
        someExample.run();          // Message from privClass!
                                    // Message from innerClass!

        SomeExample.PubClass publicClass = someExample.new PubClass();
        publicClass.printInfo();    // Message from pubClass!
    }
}
