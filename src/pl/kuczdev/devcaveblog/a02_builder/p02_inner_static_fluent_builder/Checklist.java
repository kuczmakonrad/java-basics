package pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder;

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
