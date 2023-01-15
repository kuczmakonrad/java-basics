package pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder;

public class Main {
    public static void main(String[] args) {
        Goal goal = Goal.builder()
                .name("Run the marathon")
                .description("My goal")
                .createLevelList()
                .addLevel(new Level("5km", "Cookie"))
                .addLevel(new Level("10km", "Wine"))
                .addLevel(new Level("25km", "New laptop"))
                .checklist(new Checklist("TODOS"))
                .achieved()
                .build();

        System.out.println(goal);
    }
}
