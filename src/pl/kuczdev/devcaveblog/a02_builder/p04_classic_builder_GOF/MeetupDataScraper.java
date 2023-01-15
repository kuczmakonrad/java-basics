package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

import java.util.HashMap;
import java.util.Map;

public class MeetupDataScraper implements DataScraper {
    private static final String NAME = "Meetup";
    private Map<String, JSONObject> meetupData = new HashMap<>();

    @Override
    public void scrapDataFor(String[] languages) {
        //scraping implementation for Meetup
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public JSONObject getData() {
        return new JSONObject(meetupData);
    }
}