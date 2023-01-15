package pl.kuczdev.design_patterns.singleton;

public class SingletonPattern {
    private static SingletonPattern instance;

    private SingletonPattern() {
        // init DB
    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

    public void getDBConnection() {
        System.out.println("DB Connection!");
    }
}
