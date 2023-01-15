package pl.kuczdev.__work_questions.exceptions.another_blog_exceptions;

public class q02_CatchClauseBasic {
    public static void main(String[] args) {
        try {
            System.out.println(divideTwoInts(25,0));
        } catch (ArithmeticException e) {
            System.out.println("Nie można dzielić przez zero!");
        }
    }

    private static int divideTwoInts(int i, int j) {
        return i / j;
    }
}
/*
Zastanówmy się teraz, jak powinien działać nasz program, aby obsłużyć sytuację, gdy przesłany zostanie nieprawidłowy argument. Czy program powinien:
        ** kończyć się błędem tak jak do tej pory?
        ** zwracać 0?
        ** zwracać jakąś inną wartość, np. najmniejszą z możliwych wartości, jakie może przechowywać zmienna typu int?

Żadne z powyższych rozwiązań nie jest dobre – nie chcemy, aby program kończył się błędem,a zwracanie pewnej wartości na sztywno nie jest dobrym rozwiązaniem,
bo przecież zarówno zero, jak i najmniejsza liczba, jaką może przechowywać typ int, mogą potencjalnie być wynikiem działania metody podziel.

Co zatem możemy poradzić na taką sytuację wyjątkową? Wiedząc już, czym są wyjątki, możemy obsłużyć wyjątek dzielenia przez zero,
by nasz program nie kończył się błędem.

Spójrzmy na przykład poniżej.
Tym razem na ekranie zobaczymy: Nie wolno dzielic przez 0!

W metodzie main użyliśmy mechanizmu try..catch do łapania i obsługiwania wyjątków.

W naszym przypadku, gdy w metodzie podziel próbujemy wykonać dzielenie przez 0, Maszyna Wirtualna Java rzuci wyjątek ArithmeticException,
który następnie możemy obsłużyć dzięki skorzystaniu z try..catch.

Używając instrukcji try spodziewamy się, że w instrukcjach objętych przez try coś może pójść nie tak (ale nie musi).

To, co powinno się zadziać w przypadku napotkania konkretnego problemu (i tylko wtedy), umieszczamy w sekcji catch:
    1. Najpierw w nawiasach podajemy typ wyjątku, którego się spodziewamy i który chcemy obsłużyć – w naszym przypadku jest to błąd ArithmeticException;
        po typie następuje nazwa zmiennej, za pomocą której do tego obiektu-wyjątku będziemy się mogli odnieść –
        zazwyczaj, tak jak powyżej, ta zmienna nazywana jest po prostu e.
    2. Następnie, w nawiasach klamrowych umieszczamy instrukcje, które chcemy wykonać wyłącznie w przypadku, gdy dany wyjątek zostanie rzucony –
        w powyższym przykładzie jest to tylko jedna instrukcja informująca, że nie można dzielić przez 0.
 */
