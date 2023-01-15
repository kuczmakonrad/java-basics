package pl.kuczdev.devcaveblog.a03_idiotoodporne_api_klasy;

import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Checklist;
import pl.kuczdev.devcaveblog.a02_builder.p02_inner_static_fluent_builder.Level;

/*
W wpisie z serii „Effective Java” na moim blogu omawiałem wzorzec projektowy Builder.
Była tam mowa o tym, że zazwyczaj w metodzie public Goal build() przed zbudowaniem obiektu weryfikujemy, czy wszystkie wymagane pola zostały podane.
Dla przykładowej klasy z poprzedniego wpisu wyglądało to tak:


public class Goal {
  // ...
  public static final class Builder {
    //...

    public Goal build() {
      if(name.isEmpty()){
        throw new IllegalStateException("Name cannot be empty");
      }
      if(description.isEmpty()){
        throw new IllegalStateException("Name cannot be empty");
      }
      if(levels.isEmpty()){
        throw new IllegalStateException("Levels cannot be empty");
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

Mamy tu dwa problemy:
1. Dla każdego wymaganego pola musimy pisać if, który sprawdza, czy pole zostało podane. Jeśli nie, rzuca wyjątkiem, co nie jest zbyt ładnym rozwiązaniem.
2. Klient, który używa buildera nie ma pojęcia o tym, co jest wymagane, a co nie. Dowie się dopiero wtedy, gdy spróbuje odpalić program i dostanie wyjątek.

Możemy uprzyjemnić kod dla klienta i wyeliminować te problemy poprzez odpowiednio zaprojektowanie klasy - a z pomocą przychodzą interfejsy.

W przykładzie z builderem będzie to działało tak, że przed zbudowaniem obiektu klient będzie musiał użyć wszystkich wymaganych metod w odpowiedniej kolejności.
Jeśli tego nie zrobi, nie będzie miał nawet możliwości wywołania metody build(). W skrócie - będzie cały czas prowadzony za rączkę.

Do klasy (w tym przypadku Goal) będziemy musieli dodać wewnętrzne publiczne interfejsy.
Wewnętrzne, bo nie ma potrzeby definiowania ich w globalnym zasięgu, przez co drzewo pakietowe może całkiem spuchnąć (takich interfejsów może być sporo).
Preferuję zrobić to na końcu klasy:

Jeśli klasa będzie używana tylko w tym samym pakiecie, interfejsy mogą pozostać package-private, czyli można im usunąć modyfikator dostępu public.

Interfejsy te odwzorowują kolejne kroki w używaniu API klasy.
W tym przykładzie interfejsy nazwane według konwencji Need* określają kolejne pola,
które builder musi mieć zdefiniowane oraz zwracają kolejny interfejs, który odpowiada za następny krok.
Ostatni interfejs CanBeBuild określa, że klasa jest już gotowa do wykonania finalnej metody (w tym przypadku build())
oraz umożliwia jeszcze ustawienie opcjonalnych pól.

Teraz wystarczy sprawić, żeby builder implementował wszystkie zdefiniowane interfejsy oraz zmodyfikować metodę build(),
aby zwracała interfejs buildera reprezentujący pierwszy krok.
W tym przypadku to NeedName.

Trochę zabiegu z tym jest, szczególnie w bardziej rozbudowanych przypadkach, ale dostajemy dzięki temu „idiotoodporną” klasę, której nie da się źle użyć.
Bo jak teraz wygląda korzystanie z buildera?

Dobieramy się do instancji buildera i próbujemy wywołać metodę, a tam dostępna jest tylko opcja podania name():

Zwracany jest interfejs NeedDescription i analogicznie można użyć tylko jednej metody.
Następnie zwracany jest interfejs NeedLevels, który umożliwia dodanie dowolnej liczby poziomów do naszego celu.
Z pomocą metody and() - przejście do ostatniego kroku, gdzie mamy już możliwość zbudowania obiektu lub jeszcze użyć jakiejś opcjonalnej metody.
Możemy w końcu zbudować klasę.

Jak widać, dzięki takiemu rozwiązaniu możemy w dowolny sposób manipulować tym, w jaki sposób klasa ma być używana przez klienta.
Można tak zaprojektować dowolną klasę. Jest to całkiem elastyczne i uniwersalne rozwiązanie.
*/

public class IdiotoodpornyBuilder {
    public static void main(String[] args) {
        Goal goal = Goal.builder()
                .name("NAME")
                .description("DESCRIPTION")
                .addLevels(new Level("10 km", "Candy"))
                .addLevels(new Level("20 km", "Others"))
                .and()
                .checklist(new Checklist("TODOS"))
                .achieved()
                .build();

        System.out.println(goal);
    }

}
