package pl.kuczdev.devcaveblog.a02_builder.p03_fluent_builder;

public class Level {
    private String roadKm;
    private String goalKm;

    public Level(String roadKm, String goalKm) {
        this.roadKm = roadKm;
        this.goalKm = goalKm;
    }

    @Override
    public String toString() {
        return "Level{" +
                "roadKm='" + roadKm + '\'' +
                ", goalKm='" + goalKm + '\'' +
                '}';
    }
}
