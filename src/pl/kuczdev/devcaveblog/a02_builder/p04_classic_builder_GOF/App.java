package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;
/*
Tu jest nieco zmodyfikowana wersja.
W książkowym przykładzie Director dostaje Builder w konstruktorze, jednak nie do końca rozumiem dlaczego tak jest.
Wymusza to tworzenie nowej instancji Directora za każdym razem, gdy tworzymy nowy obiekt.
Ja zaimplementowałem to tak, że używamy cały czas tego samego Directora do budowania różnych obiektów.

Productem jest po prostu JSONObject.
Jeśli chciałbym to zrobić jak w książkowym przykładzie to wyglądałoby to tak:

    JSONObject tiobeIndexStats = new Statistics(new TiobeIndexDataScraper()).build();
    JSONObject meetupStats = new Statistics(new MeetupDataScraper()).build();
    JSONObject stackOverFlowStats = new Statistics(new StackOverflowDataScraper()).build();
    JSONObject spectrumStats = new Statistics(new SpectrumDataScraper()).build();

Tylko problem pojawia się w tym, że nie mam jak podać do Directora listy języków dla których ma zebrać dane.
Musiałbym za każdym razem podawać go do konstruktora Directora lub Scrapera:

    String[] languages = {"C", "C++", "Java", "JavaScript", "Python", "Swift", "R", "Csharp", "Ruby", "PHP"};
    JSONObject tiobeIndexStats = new Statistics(new TiobeIndexDataScraper(), languages).build();
    JSONObject meetupStats = new Statistics(new MeetupDataScraper(), languages).build();
    JSONObject stackOverFlowStats = new Statistics(new StackOverflowDataScraper(), languages).build();
    JSONObject spectrumStats = new Statistics(new SpectrumDataScraper(), languages).build();


lub

    String[] languages = {"C", "C++", "Java", "JavaScript", "Python", "Swift", "R", "Csharp", "Ruby", "PHP"};
    JSONObject tiobeIndexStats = new Statistics(new TiobeIndexDataScraper(languages)).build();
    JSONObject meetupStats = new Statistics(new MeetupDataScraper(languages)).build();
    JSONObject stackOverFlowStats = new Statistics(new StackOverflowDataScraper(languages)).build();
    JSONObject spectrumStats = new Statistics(new SpectrumDataScraper(languages)).build();


Co jest nieco nadmiarowe i przynajmniej w tym wypadku robienie nowej instancji Directora za każdym razem jest zbędne.
Widziałem też przykłady gdzie wszystko było instancjonowane w osobnej linijce… Według mnie to overkill bo zamiast jednej linijki:

    JSONObject tiobeIndexStats = statistics.build(new TiobeIndexDataScraper());

byłoby coś takiego:

    TiobeIndexDataScraper tiobeIndexDataScraper = new TiobeIndexDataScraper();
    Statistics tiobeIndexDirector = new Statistics(new TiobeIndexDataScraper());
    tiobeIndexDirector.collectFor(languages):
    JSONObject tiobeIndexStats = tiobeIndexDirector.build();

To mówi chyba samo za siebie.
*/

public class App {
    public static void main(String[] args) {
        String[] languages = {"C", "C++", "Java", "JavaScript", "Python", "Swift", "R", "Csharp", "Ruby", "PHP"};

        Statistics statistics = new Statistics();
        statistics.collectFor(languages);

        JSONObject tiobeIndexStats = statistics.build(new TiobeIndexDataScraper());
        JSONObject meetupStats = statistics.build(new MeetupDataScraper());
        JSONObject stackOverFlowStats = statistics.build(new StackOverflowDataScraper());
        JSONObject spectrumStats = statistics.build(new SpectrumDataScraper());
    }

}
