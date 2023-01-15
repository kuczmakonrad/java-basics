package pl.kuczdev.data_structures.TreeMap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/*
If you want custom sorting , then you can using below TreeMap constructor. You can define your own comparator.
    TreeMap countryCapitalMap=new TreeMap(Comparator comp);

OUTPUT:
    Sorting TreeMap in reverse order of country name
    Russia----Moscow
    Japan----Tokyo
    India----Delhi
    France----Paris
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
}

public class p02_TreeMapCustomOrdering {
    public static void main(String[] args)
    {
        NewCountry india=new NewCountry("India",1000);
        NewCountry japan=new NewCountry("Japan",10000);

        NewCountry france=new NewCountry("France",2000);
        NewCountry russia=new NewCountry("Russia",20000);

        Comparator<NewCountry> comparator = new Comparator<>() {
            @Override
            public int compare(NewCountry o1, NewCountry o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        System.out.println("Sorting TreeMap in reverse order of country name");
        TreeMap<NewCountry, String> countryCapitalMap=new TreeMap<NewCountry,String>(comparator);
        countryCapitalMap.put(india,"Delhi");
        countryCapitalMap.put(japan,"Tokyo");
        countryCapitalMap.put(france,"Paris");
        countryCapitalMap.put(russia,"Moscow");

        Iterator countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line
        while(countryCapitalIter.hasNext())
        {
            NewCountry countryObj= (NewCountry) countryCapitalIter.next();
            String capital=countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName()+"----"+capital);
        }
    }
}
