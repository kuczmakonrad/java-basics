package pl.kuczdev.data_structures.TreeMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/*
    You can pass HashMap to constructor of TreeMap to sort it on Key
        TreeMap countryCapitalMap = new TreeMap(Map hm);
    By passing HashMap to constructor of TreeMap, you can sort TreeMap.

    OUTPUT:
        Sorting HashMap by passing it to TreeMap constructor
        France----Paris
        India----Delhi
        Japan----Tokyo
        Russia----Moscow
 */

// Create NewCountry.java as below. It should implement Comparable interface
class NewCountry implements Comparable {
    String name;
    long population;

    public NewCountry(String name, long population) {
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
    public int compareTo(Object o) {
        NewCountry country=(NewCountry) o;
        return this.getName().compareTo(country.getName());
    }

}
public class p03_TreeMapConstructorWithHashMap {
    public static void main(String[] args) {
        NewCountry india = new NewCountry("India",1000);
        NewCountry japan = new NewCountry("Japan",10000);
        NewCountry france = new NewCountry("France",2000);
        NewCountry russia = new NewCountry("Russia",20000);

        HashMap<NewCountry, String> countryCapitalMap=new HashMap<NewCountry,String>();
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        System.out.println("Sorting HashMap by passing it to TreeMap constructor:");
        TreeMap<NewCountry,String> sortedTreeMapCountryCapital = new TreeMap<NewCountry,String> (countryCapitalMap);
        Iterator countryCapitalIter = sortedTreeMapCountryCapital.keySet().iterator();  //put debug point at this line
        while(countryCapitalIter.hasNext()) {
            NewCountry countryObj = (NewCountry) countryCapitalIter.next();
            String capital = countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName() + "----" + capital);
        }
    }
}
