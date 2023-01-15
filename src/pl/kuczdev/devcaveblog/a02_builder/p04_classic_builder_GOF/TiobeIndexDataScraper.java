package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

import java.util.HashMap;
import java.util.Map;

public class TiobeIndexDataScraper implements DataScraper {
    private static final String NAME = "Tiobe";
    private Map<String, JSONObject> tiobeData = new HashMap<>();

    @Override
    public void scrapDataFor(String[] languages) {
        //scraping implementation for Tiobe
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public JSONObject getData() {
        return new JSONObject(tiobeData);
    }
}

