package pl.kuczdev.devcaveblog.a02_builder.p03_fluent_builder;

import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Checklist;
import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Goal;
import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Level;

public class Main {
    public static void main(String[] args) {
        Goal goal = Goal.builder()
                .name("Run the marathon")
                .description("My goal")
                .createLevelList()
                .addLevel(new pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Level("5km", "Cookie"))
                .addLevel(new pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Level("10km", "Wine"))
                .addLevel(new Level("25km", "New laptop"))
                .checklist(new Checklist("TODOS"))
                .achieved()
                .build();

        System.out.println(goal);
    }
}
