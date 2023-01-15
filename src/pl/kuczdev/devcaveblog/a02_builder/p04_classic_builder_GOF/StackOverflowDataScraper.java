package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

import java.util.HashMap;
import java.util.Map;

public class StackOverflowDataScraper implements DataScraper {
    private static final String NAME = "StackOverflow";
    private Map<String, JSONObject> stackOverflowData = new HashMap<>();

    @Override
    public void scrapDataFor(String[] languages) {
        //scraping implementation for StackOverflow
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public JSONObject getData() {
        return new JSONObject(stackOverflowData);
    }
}