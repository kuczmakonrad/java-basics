package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;
/*
Klasyczny budowniczy od gangu czworga (Gang of four) adresuje całkiem inny problem i wygląda całkiem inaczej.
Jest to bardziej strategia tworzenia obiektów, której celem jest oddzielenie tworzenia obiektu od jego reprezentacji,
dzięki czemu ten sam proces konstrukcji jest wykorzystywany do powstawania różnych reprezentacji.

W tym wzorców mamy kilka elementów:
    Builder - interfejs dla builderów
    ConcreteBuilders - jego implementacje, zawierają tak jakby plan wykonania poszczególnych części
    Director - tworzy obiekty wykorzystując Buildery, czyli wykorzystuje plany na poszczególne części
    Product - czyli to co dostaje klient od Directora

Ten wzorzec nie ma zastosowania w przykładzie z tworzeniem klasy Goal, ponieważ “cel” nie ma zazwyczaj predefiniowanych konkretnych implementacji.
Moglibyśmy tak zrobić, ale to raczej mało realny przykład.
Jako przykład mogę podać narzędzie do zbierania statystyk dla języków programowania, które tworzyłem dla mojej strony jaki-jezyk-programowania.pl.
Tam zaprojektowałem kod w podobny sposób.

Jest to “scraper”, ale zasada podobna.
Po prostu zamiast metod z przedrostkiem build, są get. Buildery mają zazwyczaj więcej takich metod, ponieważ stosuje je się do tworzenia skomplikowanych obiektów.
*/

public interface DataScraper {
    void scrapDataFor(String[] languages);
    String getName();
    JSONObject getData();
}
