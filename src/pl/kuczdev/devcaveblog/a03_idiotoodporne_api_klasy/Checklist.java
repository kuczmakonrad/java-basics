package pl.kuczdev.devcaveblog.a03_idiotoodporne_api_klasy;

public class Checklist {
    private String name;

    public Checklist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Checklist{" +
                "name='" + name + '\'' +
                '}';
    }
}
