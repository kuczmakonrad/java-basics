package pl.kuczdev.generics;

import java.util.ArrayList;
import java.util.Iterator;

class Person {
    private String name;

    public Person(String name) {
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
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Employee extends Person {
    private String jobTitle;

    public Employee(String name, String jobTitle) {
        super(name);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.getName() + "\'," +
                "jobTitle='" + jobTitle + '\'' +
                '}';
    }
}

class Contractor extends Employee {
    public Contractor(String name, String jobTitle) {
        super(name, jobTitle);
    }

    @Override
    public String toString() {
        return "Contractor{" + super.toString() + "}";
    }
}

class Organisation<T extends Person> {
    private ArrayList<T> participants;

    public Organisation() {
        this.participants = new ArrayList<T>();
    }

    public T getParticipantByIndex(int index) {
        if (index >= 0 && index < participants.size()) {
            return participants.get(index);
        }

        return null;
    }

    public void addParticipant(T participant) {
        participants.add(participant);
    }

    public void printParticipants() {
        Iterator<T> iterator = participants.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

public class OrganisationExample {
    public static void main(String[] args) {
        Organisation<Employee> organisation = new Organisation<>();
        organisation.addParticipant(new Employee("Kamil", "programista"));
        organisation.addParticipant(new Employee("Ola", "programista"));
        organisation.addParticipant(new Employee("Milena", "H&R"));
        organisation.addParticipant(new Contractor("Wiesława", "Konstruktor"));
        organisation.printParticipants();
    }
}
