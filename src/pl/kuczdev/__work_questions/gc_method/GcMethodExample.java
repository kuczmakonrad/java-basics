package pl.kuczdev.__work_questions.gc_method;
//Note: An object is eligible for garbage collection if it is unreachable or contains null value.
//Uwaga: obiekt kwalifikuje się do wyrzucania elementów bezużytecznych, jeśli jest nieosiągalny lub zawiera wartość null.
public class GcMethodExample {
    public static void main(String[] args) {
        GcMethodExample gcm = new GcMethodExample();
        gcm = null; // Nullifying the reference variable

        System.gc(); // requesting JVM for running Garbage Collector
        System.out.println("Garbage Collected!");
    }

}
