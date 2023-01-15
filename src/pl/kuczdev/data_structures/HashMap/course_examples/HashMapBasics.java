package pl.kuczdev.data_structures.HashMap.course_examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Employee {
    private String name;

    public Employee(String name) {
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
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap <String, Employee> map = new HashMap<>();
        map.put("Konrad", new Employee("Konrad"));
        map.put("Kamil", new Employee("Kamil"));
        map.put("Emil", new Employee("Emil"));
        map.put("Konrad", new Employee("Konrad K"));            // W takim przypadku nadpiszemy klucz Konrad o nową wartość Konrad K (nasuwa się wniosek, że należy sprawdzać czy dany klucz istnieje przed dodaniem do mapy)

        Employee e1 = map.get("Emil");
        System.out.println(e1);

        System.out.println("Iterator loop:");
        Iterator i = map.entrySet().iterator();

        while(i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            String key = (String) entry.getKey();
            Employee value = (Employee) entry.getValue();
            System.out.println(key + " - " + value);
        }

        System.out.println("\nForEach loop:");

        for (Map.Entry<String,Employee> entry: map.entrySet()) {
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
