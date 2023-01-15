package pl.kuczdev.devcaveblog.a02_builder.p03_fluent_builder;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class GoalBuilder {
    private String name;
    private String description;
    private List<Level> levels;
    private Checklist checklist;
    private LocalDate deadline;
    private boolean achieved = false;

    public GoalBuilder name(String name) {
        this.name = name;
        return this;
    }

    public GoalBuilder description(String description) {
        this.description = description;
        return this;
    }
    // ze względu na łatwiejszą budowę (więcej w liniach 55-96).
        /*
        public Builder levels(List<Level> levels) {
            this.levels = levels;
            return this;
        }
         */

    public GoalBuilder createLevelList() {
        this.levels = new ArrayList<>();
        return this;
    }

    public GoalBuilder addLevel(Level level) {
        this.levels.add(level);
        return this;
    }

    public GoalBuilder checklist(Checklist checklist) {
        this.checklist = checklist;
        return this;
    }

    public GoalBuilder deadline(LocalDate deadline) {
        this.deadline = deadline;
        return this;
    }

    public GoalBuilder achieved() {
        this.achieved = true;
        return this;
    }

    public Goal build() {
        if (name.isEmpty()) {
            throw new IllegalStateException("Name cannot be empty!");
        }

        if (levels.isEmpty()) {
            throw new IllegalStateException("Levels cannot be empty!");
        }

        Goal goal = new Goal();
        goal.setDeadline(this.deadline);
        goal.setName(this.name);
        goal.setChecklist(this.checklist);
        goal.setLevels(this.levels);
        goal.setDescription(this.description);
        goal.setAchieved(this.achieved);
        return goal;
    }
}