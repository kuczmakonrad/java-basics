package pl.kuczdev.oop_basics.interface_extends_default_static_final_methods;

public interface Eating {
    public void eat();

    public default void searchForFood() {
        System.out.println("Searching for food!");
    }
}
