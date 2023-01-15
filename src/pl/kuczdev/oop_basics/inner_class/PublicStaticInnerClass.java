package pl.kuczdev.oop_basics.inner_class;

class CarObj {
    private String modelName;
    private String manufacturer;
    private int year;

    public static class CarObjBuilder {
        private CarObj car = new CarObj();

        public CarObjBuilder setModelName(String modelName) {
            car.modelName = modelName;
            return this;
        }

        public CarObjBuilder setManufacturer(String manufacturer) {
            car.manufacturer = manufacturer;
            return this;
        }

        public CarObjBuilder setYear(int year) {
            car.year = year;
            return this;
        }

        public CarObj getCar() {
            return car;
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CarObj{" +
                "modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }
}

public class PublicStaticInnerClass {
    public static void main(String[] args) {
        CarObj car1 = new CarObj.CarObjBuilder()
                .setManufacturer("Dogde")
                .setModelName("Viper")
                .setYear(1990)
                .getCar();

        System.out.println(car1.getManufacturer() + " "  + car1.getModelName() + " " + car1.getYear()); //Dogde Viper 1990
        System.out.println(car1);       //CarObj{modelName='Viper', manufacturer='Dogde', year=1990}
    }
}
