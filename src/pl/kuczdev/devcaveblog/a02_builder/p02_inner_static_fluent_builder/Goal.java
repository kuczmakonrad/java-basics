package pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*
Kolejne metody służą do konfigurowania pól w klasie Goal (możemy przeprowadzić też w nich walidację), które zwracają obiekt buildera,
aby umożliwić ciągłe wywoływanie kolejnych metod (Fluent API).
Ostatnia z nich - public Goal build() służy do zbudowania obiektu i najczęściej przed tym do zweryfikowania czy wszystkie wymagane pola zostały zainicjowane.

Istnieje też inny fajny sposób, aby wymusić ustawienie wszystkich pól w builderze - więcej tutaj - ...\DesignPatterns\src\pl\kuczdev\devcaveblog\a03_idiotoodporne_api_klasy

Stosując wzorzec builder możemy zagwarantować, że stworzona zostanie poprawna i kompletna klasa, zachowując czysty i łatwy w użyciu kod. Instancjonowanie klasy wygląda wtedy tak:

    Goal goal = new Goal.Builder()
        .name("Run the marathon")
        .description("My goal")
        .levels(levels)
        .checklist(checklist)
        .achieved()
        .build();


Jak widać jest to dużo łatwiejsze do czytania jak i używania. Kolejne pola możemy podać w dowolnej kolejności, ze względu na wspomniane wcześniej fluent API.

Osobiście dla mnie składnia new Goal.Builder() wygląda paskudnie, dlatego preferuję użyć tutaj static factory method, żeby uzyskać dostęp do buildera w statyczny sposób, bez użycia new:

    public static Builder builder() {
        return new Builder();
    }


I wtedy buildera możemy używać tak:

    Goal goal = Goal.builder()
        .name("Run the marathon")
        .description("My goal")
        .levels(levels)
        .checklist(checklist)
        .achieved()
        .build();

Możemy też uniemożliwić instancjonowanie klasy zwykłym konstruktorem dodając go jako prywatny:

    private Goal() {
    }


    Zalety takiego rozwiązania:
        + Pozwala zachować niemutowalność klasy.
            W tym wariancie buildera nie musimy udostępniać publicznego konstruktora ani setterów dla budowanego obiektu.

        + Wymuszone użycia buildera, aby utworzyć instancję klasy.
            Dzięki temu możemy zapewnić, że klasa będzie zawsze spójna (jeśli zadbamy o to w Builderze).

        + Builder może mieć kilka parametrów var args.
            A to dzięki temu, że każdy parametr jest w oddzielnej metodzie.
            Dodatkowym plusem jest to, że możemy dodawać elementy np. do list w dynamiczny sposób, zamiast wypełniać całą listę wcześniej i przekazywać ją do konstruktora.
            W przykładzie buildera można to zrobić np. dla listy poziomów:

                //...
                public Builder addLevel(Level level) {
                    this.levels.add(level);
                    return this;
                }
                //...


            i wtedy zamiast takiego podawania poziomów:

                List<Level> levels = new ArrayList<>();
                levels.add(new Level("5km", "Cookie"));
                levels.add(new Level("10km", "Wine"));
                levels.add(new Level("25km", "New laptop"));

                Goal goal = Goal.builder()
                    .name("Run the marathon")
                    .description("My goal")
                    .levels(levels)
                    .checklist(checklist)
                    .achieved(false)
                    .build();


            Można podać tak:

                Goal goal = Goal.builder()
                    .name("Run the marathon")
                    .description("My goal")
                    .addLevel(new Level("5km", "Cookie"))
                    .addLevel(new Level("10km", "Wine"))
                    .addLevel(new Level("25km", "New laptop"))
                    .checklist(checklist)
                    .achieved(false)
                    .build();

            Podobnie można by zrobić z checklistą. Wszystko ku lepszej czytelności.

*/



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
    public static Builder builder() {
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

    public static final class Builder {
        private String name;
        private String description;
        private List<Level> levels;
        private Checklist checklist;
        private LocalDate deadline;
        private boolean achieved = false;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
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

        public Builder createLevelList() {
            this.levels = new ArrayList<>();
            return this;
        }

        public Builder addLevel(Level level) {
            this.levels.add(level);
            return this;
        }

        public Builder checklist(Checklist checklist) {
            this.checklist = checklist;
            return this;
        }

        public Builder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder achieved() {
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
           goal.deadline = this.deadline;
           goal.name = this.name;
           goal.checklist = this.checklist;
           goal.levels = this.levels;
           goal.description = this.description;
           goal.achieved = this.achieved;
           return goal;
        }
    }
}