package pl.kuczdev.devcaveblog.a02_builder.p03_fluent_builder;

import java.time.LocalDate;
import java.util.List;

/*
FluentBuilder różni się od InnerStaticFluentBuildera tym, że pierwszy implementujemy jako osobną klasę.
Niesie to za sobą pewne konsekwencje:
    - Musimy udostępnić settery dla prywatnych pól budowanego obiektu.
    - Musimy udostępnić publiczny konstruktor.

Często takie rozwiązanie się nie sprawdza np. ze względu na to, że obiekt powinien być niemutowalny, dlatego preferowana jest implementacja jako wewnętrzna statyczna klasa.
Użycie wygląda podobnie:

    Goal goal = new GoalBuilder()
        .name("Run the marathon")
        .description("My goal")
        .levels(levels)
        .checklist(checklist)
        .achieved(false)
        .build();
 */

public class Goal {
    private String name;
    private String description;
    private List<Level> levels;
    private Checklist checklist;
    private LocalDate deadline;
    private boolean achieved;

    // Musimy udostępnić publiczny konstruktor.
    public Goal() {
    }

    //Osobiście dla mnie składnia new Goal.Builder() wygląda paskudnie, dlatego preferuję użyć tutaj static factory method,
    //żeby uzyskać dostęp do buildera w statyczny sposób, bez użycia new.
    public static GoalBuilder builder() {
        return new GoalBuilder();
    }

    @Override
    public String toString() {
        return "Goal{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", levels=" + levels +
                ", checklist=" + checklist +
                ", deadline=" + deadline +
                ", achieved=" + achieved +
                '}';
    }

    // Musimy udostępnić settery dla prywatnych pól budowanego obiektu.

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
}