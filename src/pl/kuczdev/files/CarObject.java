package pl.kuczdev.files;

import java.io.Serializable;

public class CarObject implements Serializable {
    private String name;
    private String manufacturer;
    private int productionYear;
    public int topSpeed;
    public transient int id;

    public CarObject(String name, String manufacturer, int productionYear, int topSpeed, int id) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.topSpeed = topSpeed;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarObject{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productionYear=" + productionYear +
                ", topSpeed=" + topSpeed +
                ", id=" + id +
                '}';
    }
}
