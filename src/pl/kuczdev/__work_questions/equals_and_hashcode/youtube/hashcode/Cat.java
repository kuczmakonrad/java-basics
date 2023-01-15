package pl.kuczdev.__work_questions.equals_and_hashcode.youtube.hashcode;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        // sprawdzenie czy obiekt klasy wskazuje na przekazany obiekt
        if (this == object) {
            return true;
        }
        // sprawdzenie czy przekazany obiekt nie jest pusty
        if (object == null) {
            return false;
        }

        // sprawdzenie czy przekazany obiekt jest innej klasy
        if (!(object instanceof Cat)) {
            return false;
        } else {
            Cat o = (Cat) object;

        if (name.equals(o.name) && age == o.age) {          // sprawdzenie wartości w obiektach
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
   }

}

