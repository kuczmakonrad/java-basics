package pl.kuczdev.__work_questions.overload_overwrite;

class Bird {
    protected void sing() {
        System.out.println("SINGING FROM BIRD CLASS! ćwir ćwir!!!");
    }

    protected void testing() {
        System.out.println("TESTING FROM BIRD CLASS!");
    }


}

class Parrot extends Bird {
    @Override
    protected void sing() {
        System.out.println("SINGING FROM PARROT CLASS! krr krrr!!!");
    }

    protected void testing() {
        System.out.println("TESTING FROM PARROT CLASS!");
    }

}

public class OverwritingExample {
    public static void main(String[] args) {
        Bird bird = new Bird();
        System.out.println("FOR OBJECT:\nBird bird = new Bird();\nMethod sing() result below: ");
        bird.sing();
        bird.testing();
        System.out.println("-----------------------------------------------------------");

        Parrot parrot = new Parrot();
        System.out.println("FOR OBJECT:\nParrot parrot = new Parrot();\nMethod sing() result below: ");
        parrot.sing();
        parrot.testing();
        System.out.println("-----------------------------------------------------------");

        Bird bird1 = new Parrot();
        System.out.println("FOR OBJECT:\nBird bird1 = new Parrot();\nMethod sing() result below: ");
        bird1.sing();
        bird1.testing();
        System.out.println("-----------------------------------------------------------");

        // Parrot parrot5 = new Bird(); - not possible
    }
}
