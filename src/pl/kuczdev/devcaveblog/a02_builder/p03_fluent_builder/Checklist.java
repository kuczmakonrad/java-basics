package pl.kuczdev.devcaveblog.a02_builder.p03_fluent_builder;

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
