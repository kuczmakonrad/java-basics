package pl.kuczdev.__work_questions.equals_and_hashcode.devcave.equals;

public class Main {
    public static void main(String[] args) {
        PhoneNumber phoneNumber1 = new PhoneNumber("NOKIA", 1000, 30);
        PhoneNumber phoneNumber2 = new PhoneNumber("NOKIA", 1000, 30);
        //PhoneNumber phoneNumber3 = new PhoneNumber("NOKIA", 100000, 30);

        System.out.println("Czy obiekty phoneNumber1/2 wskazują na ten sam obiekt (ph1 == ph2)?: " + (phoneNumber1 == phoneNumber2));
        System.out.println("Czy obiekty phoneNumber1/2 są równe (ph1.equals(ph2))?: " + (phoneNumber1.equals(phoneNumber2)));

    }
}
