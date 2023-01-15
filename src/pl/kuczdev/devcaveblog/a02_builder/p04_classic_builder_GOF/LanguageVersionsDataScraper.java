package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

import java.util.HashMap;
import java.util.Map;

public class LanguageVersionsDataScraper implements DataScraper{
    private static final String NAME = "Spectrum";
    private Map<String, JSONObject> spectrumData = new HashMap<>();

    @Override
    public void scrapDataFor(String[] languages) {
        //scraping implementation for Spectrum
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public JSONObject getData() {
        return new JSONObject(spectrumData);
    }
}