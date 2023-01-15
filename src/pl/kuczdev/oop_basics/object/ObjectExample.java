package pl.kuczdev.oop_basics.object;

public class ObjectExample {
    public static void main(String[] args) {
        CarObject car1 = new CarObject("Ford", "Mustang", 1960);
        CarObject car2 = new CarObject("Dogde", "Viper", 2020);
        System.out.println(car1);               // car1.toString()
                                                // bez nadpisania metody OUTPUT = pl.kuczdev.oop_basics.object.CarObject@eed1f14
                                                // po nadpisaniu metody OUTPUT = CarObject{manufacturer='Ford', model='Mustang', year=1960}
        System.out.println(car1.hashCode());    // car1.hashCode() = 668386784

        // OUTPUT = car1 != car2 (wskazują na różne referencje)
        if (car1.equals(car2)) {
            System.out.println("car1 = car2 (wskazują na tą samą referencję)");
        } else {
            System.out.println("car1 != car2 (wskazują na różne referencje)");
        }
    }
}
