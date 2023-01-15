package pl.kuczdev.devcaveblog.a02_builder;
/*
Zazwyczaj tworzymy klasy i inicjujemy jej pola za pomocą konstruktora z argumentami lub bezargumentowym konstruktorem i setterami.
Nic złego w tym nie ma dopóki ilość argumentów nie przekracza 4-5 i mamy pola, które muszą zostać dostarczone.
W takich wypadkach warto zastanowić się nad lepszym rozwiązaniem.

Weźmy na przykład taką oto klasę:

    public class Goal {
        private String name;
        private String description;
        private List<Level> levels;
        private Checklist checklist;
        private LocalDate deadline;
        private boolean achieved;
    }


Posiada 6 pól do zainicjowania, nie wszystkie są wymagane, ale część jest kluczowa. Jak w takim przypadku będzie wyglądał konstruktor, jeśli chcemy użyć tego podejścia?

    public Goal(String name, ArrayList<Level> levels, Checklist checklist, boolean achieved) {
        this.name = name;
        this.levels = levels;
        this.checklist = checklist;
        this.achieved = achieved;
    }


Nie jest źle, ilość wymaganych argumentów nie jest jeszcze przytłaczająca. Jak wygląda tworzenie instancji takiej klasy przez klienta?

    List<Level> levels = new ArrayList<>();

    levels.add(new Level("5km", "Cookie"));
    levels.add(new Level("10km", "Wine"));
    levels.add(new Level("25km", "New laptop"));

    Checklist checklist = new Checklist("Todos");
    checklist.addItem(new ListItem("Buy shoes"));
    checklist.addItem(new ListItem("Run every second day"));
    checklist.addItem(new ListItem("Other"));

    Goal goal = new Goal("Run the marathon", "My goal", levels, checklist, false);
    //goal.setDeadline();  //Optional


Opcjonalnymi i wymaganymi polami można łatwo zarządzać używając konstruktorów.
Możemy przypisać im wartości domyślne, wymusić utworzenie obiektu z określonymi parametrami itd.
Jednak to co zaczyna być mało praktyczne to konstruktor:

    Goal goal = new Goal("Run the marathon", "My goal", levels, checklist, false);


Ma 5 argumentów i zaczyna to być już mało czytelne.
Szczególnie dla osoby, która nie pisała tego kodu.
Po jakimś czasie i dla nas samych.
Nie jest od razu jasne co jest czym.
Przekazujemy jakieś dwa stringi, dwie listy i jakąś wartość boolean.
Obecnie niektóre IDE np. InteliJ mają funkcje, które dopisują nazwę argumentu przed nim.
Jest to małe ułatwienie, jednak nie powinniśmy na tym polegać.
Kod powinien być czysty sam w sobie, a nie polegać na IDE.


Użycie podejścia z bezargumentowym konstruktorem i setterami poprawia czytelność kodu:

    Goal goal = new Goal();
    goal.setName("Run the marathon");
    goal.setDescription("My goal");
    goal.setLevels(levels);
    goal.setChecklist(checklist);
    goal.setAchievied(false);


Jednak nie gwarantuje ono spójności klasy.
Nie ma tutaj opcji, aby zmusić klienta, żeby ustawił wszystkie wymagane pola.
Uniemożliwia to też stworzenie klasy niemutowalnej, co wymaga dodatkowego wysiłku, aby zapewnić thread safety.
I tu z pomocą przychodzi Builder.


Budowniczy (Builder) - wzorzec projektowy
Ten wzorzec projektowy ma kilka wariantów.
W książce Effective Java poruszany jest tylko ten pierwszy.
Dwa pozostałe są jako dodatek, który warto porównać.
Ogólnie mówiąc Buildery są dodatkowymi klasami, który ułatwiają tworzenie innych złożonych klas.



Pisanie builderów jest nużące i powtarzalne, dlatego powstały liczne pluginy do IDE, które generują je za nas.
Dla InteliJ mamy na przykład plugin Builder Generator. Po zainstalowaniu wystarczy kliknąć Alt+Shift+B i wyskoczy nam opcja do wygenerowania buildera.

Powstały również do tego całe biblioteki.
Jedną z nich jest np. Lombok (Który udostępnia szereg innych funkcji).
Wystarczy dorzucić do klasy adnotację @Builder i już możemy korzystać z Buildera za pomocą statycznej metody builder().



Wady:
    - Koszt tworzenia buildera
        Kod buildera jest dosyć rozwlekły.
        Koszt napisania buildera nie jest może zbyt duży (szczególnie jeśli zostanie wygenerowany), jednak może mieć znaczenie wydajnościowe.
        Dlatego ten wzorzec powinniśmy stosować tylko wtedy kiedy klasa będzie mieć przynajmniej 4 wymagane pola (lub wiemy, że ta liczba urośnie)
        i nie jest to aplikacja performance-critical.
        Przy mniejszej ilości parametrów jest to overengineering.


Gdyby w Javie występowały parametry nazwane (tak jak np. w Kotlinie), to ten wzorzec byłby zbędny.
Można by powiedzieć, ze jest to bardziej obejście dla brakującej funkcjonalności języka niż wzorzec projektowy. Gdyby Java miała taki feature to wystarczyłoby użyć konstruktora:

    Goal goal = new Goal(
        name="Run the marathon",
        description="My goal",
        levels=levels,
        checList=checklist,
        achieved=false);

*/



public class p01_BuilderBasic {
}
