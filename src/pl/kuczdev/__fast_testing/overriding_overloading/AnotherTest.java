package pl.kuczdev.__fast_testing.overriding_overloading;

class MotherClass {
    public void voice() {
        System.out.println("MOTHER SAY: GO TO SCHOOL");
    }
}

class ChildClass extends MotherClass {
    public void voice() {
        System.out.println("CHILD SAY: MOM I DONT WANT TO!!!");
    }
}

public class AnotherTest {
    public static void main(String[] args) {
        MotherClass mc = new ChildClass();
        mc.voice();
    }
}
