package pl.kuczdev.__work_questions.comparator_comparable_difference;
/*
One of the common interview question is:
    * “What are differences between Comparator and Comparable”,
    * “How will you sort collection of employee objects by its id or name”.
For that we can use two interfaces.i.e. Comparator and Comparable.


Comparable interface:
    Class whose objects to be sorted must implement this interface.In this,we have to implement compareTo(Object) method.
        For example:
            public class Country implements Comparable {
                @Override
                public int compareTo(Country country) {
                    return (this.countryId < country.countryId) ? -1: (this.countryId > country.countryId) ? 1:0 ;
                }
            }
    If any class implements comparable inteface then collection of that object can be sorted automatically using Collection.sort() or Arrays.sort().
    Object will be sort on the basis of compareTo method in that class.
    Objects which implement Comparable in java can be used as keys in a SortedMap like TreeMap or SortedSet like TreeSet without implementing any other
    interface.


Comparator interface:
    Class whose objects to be sorted do not need to implement this interface.Some third class can implement this interface to sort
    .e.g.CountrySortByIdComparator class can implement Comparator interface to sort collection of country object by id.
        For example:
            public class CountrySortByIdComparator implements Comparator{
                @Override
                public int compare(Country country1, Country country2) {
                    return (country1.getCountryId() < country2.getCountryId() ) ? -1: (country1.getCountryId() > country2.getCountryId() ) ? 1:0 ;
                }
            }


Using Comparator interface, we can write different sorting based on different attributes of objects to be sorted.
You can use anonymous comparator to compare at particular line of code. For example:

         Country indiaCountry=new Country(1, "India");
         Country russiaCountry=new Country(4, "Russia");
         Country englandCountry=new Country(3, "England");
         Country germanyCountry=new Country(2, "Germany");

         List listOfCountries = new ArrayList();
         listOfCountries.add(indiaCountry);
         listOfCountries.add(russiaCountry);
         listOfCountries.add(englandCountry);
         listOfCountries.add(germanyCountry);

         //Sort by countryName
         Collections.sort(listOfCountries,new Comparator() {
             @Override
             public int compare(Country o1, Country o2) {
                 return o1.getCountryName().compareTo(o2.getCountryName());
             }
         });


Comparator vs Comparable:
    1. Sorting logic:
        ** Comparable:
            Sorting logic must be in same class whose objects are being sorted. Hence this is called natural ordering of objects.
        ** Comparator:
            Sorting logic is in separate class.
            Hence we can write different sorting based on different attributes of objects to be sorted.
            E.g. Sorting using id,name etc.

    2. Implementation:
        ** Comparable:
            Class whose objects to be sorted must implement this interface.
            e.g Country class needs to implement comparable to collection of country object by id.

        ** Comparator:
            Class whose objects to be sorted do not need to implement this interface.
            Some other class can implement this interface.
            E.g.-CountrySortByIdComparator class can implement Comparator interface to sort collection of country object by id.

    3. Sorting method:
        ** Comparable:
            int compareTo(Object o1)
            This method compares this object with o1 object and returns a integer. Its value has following meaning:
                1. positive – this object is greater than o1
                2. zero – this object equals to o1
                3. negative – this object is less than o1
        ** Comparator:
        int compare(Object o1,Object o2)
            This method compares o1 and o2 objects. and returns a integer.Its value has following meaning:
                1. positive – o1 is greater than o2
                2. zero – o1 equals to o2
                3. negative – o1 is less than o1

    4. Calling method:
        ** Comparable:
            Collections.sort(List)
            Here objects will be sorted on the basis of CompareTo method.
        ** Comparator:
            Collections.sort(List, Comparator)
            Here objects will be sorted on the basis of Compare method in Comparator.

    5. Package:
        ** Comparable: Java.lang.Comparable
        ** Comparator: Java.util.Comparator
*/