package pl.kuczdev.data_structures.TreeMap.course_examples;



import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnimalElement{" +
                "name='" + name + '\'' +
                '}';
    }
}

class AnimalElementComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class TreeSetComparator {
    public static void main(String[] args) {
        TreeSet <Animal> treeSet = new TreeSet<>(new AnimalElementComparator());
        treeSet.add(new Animal("Tiger"));
        treeSet.add(new Animal("Cobra"));
        treeSet.add(new Animal("Panda"));
        treeSet.add(new Animal("Tiger"));

        Iterator<Animal> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            Animal a = iterator.next();
            System.out.println(a);
        }
    }
}
