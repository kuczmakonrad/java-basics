package pl.kuczdev.devcaveblog.a03_idiotoodporne_api_klasy;

import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Checklist;
import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Level;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Goal {
    private String name;
    private String description;
    private List<Level> levels;
    private Checklist checklist;
    private LocalDate deadline;
    private boolean achieved;

    // konstruktor prywatny, gdyż dostęp do instancji przez static factory method
    private Goal() {
    }

    //Osobiście dla mnie składnia new Goal.Builder() wygląda paskudnie, dlatego preferuję użyć tutaj static factory method,
    //żeby uzyskać dostęp do buildera w statyczny sposób, bez użycia new.
    public static NeedName builder() {
        return new Builder();
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

    public static class Builder implements NeedName, NeedDescription, NeedLevels, CanBeBuild {
        private String name;
        private String description;
        private List<Level> levels;
        private Checklist checklist;
        private LocalDate deadline;
        private boolean achieved = false;

        @Override
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createEmptyLevelList() {
            this.levels = new ArrayList<>();
            return this;
        }

        @Override
        public Builder addLevels(Level level) {
            if (this.levels == null) {
                this.levels = new ArrayList<>();
            }

            this.levels.add(level);
            return this;
        }

        @Override
        public Builder checklist(Checklist checklist) {
            this.checklist = checklist;
            return this;
        }

        @Override
        public Builder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder achieved() {
            this.achieved = true;
            return this;
        }

        @Override
        public Builder and() {
            return this;
        }

        public Goal build() {
           Goal goal = new Goal();
           goal.deadline = this.deadline;
           goal.name = this.name;
           goal.checklist = this.checklist;
           goal.levels = this.levels;
           goal.description = this.description;
           goal.achieved = this.achieved;
           return goal;
        }
    }


    public interface NeedName {
        public NeedDescription name(String name);
    }

    public interface NeedDescription {
        NeedLevels description(String description);
    }

    public interface NeedLevels {
        NeedLevels addLevels(Level level);

        CanBeBuild and();
    }

    public interface CanBeBuild {
        CanBeBuild checklist(Checklist checklist);
        CanBeBuild deadline(LocalDate deadline);
        CanBeBuild achieved();
        Goal build();
    }
}