package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

public class Statistics {
    private String[] languages;

    public void collectFor(String[] languages) {
        this.languages = languages;
    }

    public JSONObject build(DataScraper dataScraper) {
        JSONObject statistics = new JSONObject();
        dataScraper.scrapDataFor(languages);
        statistics.put("name", dataScraper.getName());
        statistics.put("data", dataScraper.getData());
        return statistics;
    }
}

