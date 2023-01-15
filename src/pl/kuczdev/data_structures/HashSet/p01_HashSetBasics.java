package pl.kuczdev.data_structures.HashSet;

import java.util.HashSet;
import java.util.Iterator;

/*
HashSet implements Set interface which does not allow duplicate value.
It is not synchronized and is not thread safe.
Definition of duplicate can be quite tricky sometimes.
Lets consider two cases here.
    1. In case of primitive types (such as interger, String)
    2. In case of custom defined objects.

A few points to remember:
1. HashSet implements Set interface and it does not allow duplicate elements
2. HashSet does not maintain insertion order
3. It is not synchronized and not thread safe
4. Its worked on hashMap and adding for value private static final object.
5. Needs to implements equals and hashCode to working well (not default implementation hashCode/equals from Object class).
 */
class Country {
    String name;
    long population;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Country other = (Country) o;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    // If we delete hashCode method there will be two objects in countrySet, because it will use default hashCode and two objects will point on other place in memory
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}

public class p01_HashSetBasics {
    public static void main(String[] args) {
        // In case of primitive types (such as interger, String):
        HashSet nameSet = new HashSet();
        nameSet.add("Arpit");
        nameSet.add("Arpit");
        nameSet.add("John");
        System.out.println("size of nameSet = " + nameSet.size());  // OUTPUT: size of nameSet = 2
        System.out.println(nameSet);                                // OUPUT: [Arpit, John]

        System.out.println("-------------------------------");
        // In case of Custom Objects:
        HashSet countrySet = new HashSet();
        Country india1 = new Country("India");
        countrySet.add(india1);

        Country india2 = new Country("India");
        countrySet.add(india2);

        System.out.println("size of countrySet = " + countrySet.size());
        System.out.println(countrySet);

        System.out.println("-------------------------------");
        // example of iteration with Iterator
        Iterator<Country> it = countrySet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
