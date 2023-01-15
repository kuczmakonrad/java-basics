package pl.kuczdev.__work_questions.data_structures.HashMap;

import java.util.HashMap;
/*
You can store custom objects as Key in HashMap but you should implement hashcode and equals method, otherwise it may not work as expected.
 */

class Country {
    String name;
    long population;

    public Country(String name, long population) {
        super();
        this.name = name;
        this.population = population;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (population ^ (population >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Country: "+name+" | population:"+population;
    }
}

public class p06_HashMapStoringCustomObjectsAsKeysRule {
    public static void main(String[] args) {
        Country india=new Country("India",10000);
        Country japan=new Country("Japan",3000);
        Country france=new Country("France",5000);
        Country russia=new Country("Russia",4000);

        // HashMap with Country name as key and capital as value
        // HashMap stores elements in key value pairs
        HashMap<Country,String> countryCapitalMap=new HashMap<>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        System.out.println("-----------------------------");
        // Iterating HashMap Using keySet() and for each loop
        System.out.println("Iterating HashMap Using keySet() and for each loop");
        for (Country countryKey : countryCapitalMap.keySet()) {
            System.out.println(countryKey + " and Capital:" + countryCapitalMap.get(countryKey));
        }
        System.out.println("-----------------------------");
    }
}
