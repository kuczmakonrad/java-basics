package pl.kuczdev.devcaveblog.a02_builder.p04_classic_builder_GOF;

import java.util.HashMap;
import java.util.Map;

public class GithubDataScraper implements DataScraper {
    private static final String NAME = "Github";
    private Map<String, JSONObject> githubData = new HashMap<>();

    @Override
    public void scrapDataFor(String[] languages) {
        //scraping implementation for Github
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public JSONObject getData() {
        return new JSONObject(githubData);
    }
}