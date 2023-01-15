package pl.kuczdev.oop_basics.interface_extends_default_static_final_methods;

public interface Flying {
    public static final float DEFAULT_WINGSPAN = 0.7f;
    public void fly();

    public default void flyHigher() {
        System.out.println("Flying Higher");
    }

    public default float getWingspan() {
        return Flying.DEFAULT_WINGSPAN;
    }

    // metoda statyczna - nie wymaga słówka default
    public static int getDefaultNumWings() {
        return 2;
    }
}
