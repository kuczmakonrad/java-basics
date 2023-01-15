package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;
/*
Złapanie wyjątku nie musi oznaczać zakończenia obsługi sytuacji wyjątkowych – złapany wyjątek można rzucić ponownie (exception rethrow),
by został obsłużony przez metodę "wyżej" (tzn. jedną z wcześniejszych metod, które doprowadziły do wykonania metody, w której wyjątek był obsługiwany).

Jaki jest sens takiego działania? Możemy chcieć obsłużyć pewien wyjątek w dany sposób, a także dać szansę na jego obsłużenie w jednej z wcześniejszych metod.

Dla przykładu – wywołując metodę, która rzuca wyjątek, łapiemy go i zapisujemy do pliku logu informację, że wystąpił błąd.
Moglibyśmy też umieścić w obiekcie wyjątku dodatkowe informacje o okolicznościach błędu.
Następnie rzucamy ten wyjątek "dalej", by został obsłużony ponownie, potencjalnie już bez ponownego rzucania.

Do ponownego rzucania wyjątku stosuje się po prostu słowo kluczowe throw, po którym następuje wyjątek, który chcemy "rzucić dalej".

W tym przykładzie glownaMetoda wywołuje metodę pewnaMetoda i spodziewa się potencjalnego wyjątku PewienWyjatek,
ponieważ pewnaMetoda deklaruje za pomocą throws, że taki wyjątek może rzucić. Dlatego też glownaMetoda zawiera try..catch i obsługę PewienWyjatek.

pewnaMetoda wykonuje pewne instrukcje, które mogą skutkować rzuceniem wyjątku PewienWyjatek.
Obsługujemy go w sekcji catch, po czym rzucamy go "dalej" – teraz obsłuży go metoda glownaMetoda.
*/


class PewienWyjatek extends Exception {}

public class q06f_ThrowExceptionInCatchClause {
    public static void glownaMetoda() {
        try {
            pewnaMetoda();
        } catch (PewienWyjatek e) {
            // ponowna obsluga wyjatku PewienWyjatek
        }
    }
    public static void pewnaMetoda() throws PewienWyjatek {
        try {
            // ...
            // instrukcje ktora moga spowodowac PewienWyjatek
            // ...
            throw new PewienWyjatek();
        } catch (PewienWyjatek e) {
            // zapisz informacje o bledzie do pliku logu
            // log.error("Wystapil blad " + e.getMessage());
            e.printStackTrace();
            // rzuc wyjatek dalej
            throw e;
        }
    }
}
