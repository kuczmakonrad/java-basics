package pl.kuczdev.devcaveblog.a03_idiotoodporne_api_klasy;

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
