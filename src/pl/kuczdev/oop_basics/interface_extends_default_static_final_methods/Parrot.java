package pl.kuczdev.oop_basics.interface_extends_default_static_final_methods;

public class Parrot implements Bird{
    @Override
    public int getNumLegs() {
        return 2;
    }

    @Override
    public String getName() {
        return "Parrot";
    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void fly() {
        System.out.println("Parrot is Flying");
    }

    // opcjonalne nadpisanie metody, gdyż ma domyślną implementację
    @Override
    public void searchForFood() {
        System.out.println("Parrot is searching for food");
    }
}
