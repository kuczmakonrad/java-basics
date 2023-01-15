package pl.kuczdev.__work_questions.equals_and_hashcode.java2blog.equals_hashcode;
/*
These methods can be found in the Object class and hence available to all java classes.
Using these two methods, an object can be stored or retrieved from a Hashtable, HashMap or HashSet.
    * hashcode()
    * equals()

hashcode():
    You might know if you put entry in HashMap,
    first hashcode is calculated and this hashcode used to find bucket(index) where this entry will get stored in hashMap.
    You can read more at How hashMap works in java. What if you don’t override hashcode method, it will  return integer representation of memory address.

equals():
    You have to override equals method, when you want to define equality between two object.
    If you don’t override this method, it will check for reference equality(==) i.e. if tow reference refers to same object or not.


You don’t have to always override these methods, but lets say you want to define equality of country object based on name,
then you need to override equals method and if you are overriding equals method, you should override hashcode method too.

Below example will make it clear.

When you run above program, you will get following output
    Is india1 is equal to india2:false

In above program, we have created two different objects and set their name attribute to “india”.
Because both references india1 and india2 are pointing to different object, as default implementation of equals check for ==,
equals method is returning false.
In real life, it should have return true because no two countries can have same name.
Now lets override equals and return true if two country’s name are same.
    Is india1 is equal to india2:true
Now this is because overriden equals method return true if two country have same name.
One thing to remember here, signature of equals method should be same as above.




Lets put this Country objects in hashmap:
When you run above program, you will see following output:
    Capital of India----Delhi
    Capital of India----Delhi

Now you must be wondering even through two objects are equal why HashMap contains two key value pair instead of one.
This is because First HashMap uses hashcode to find bucket for that key object,
if hashcodes are same then only it checks for equals method and because hashcode for above two country objects uses default hashcode method,
Both will have different memory address hence different hashcode.


Now lets override hashcode method.Add following method to Country class
    Capital of India----Delhi

So now hashcode for above two objects india1 and india2 are same, so Both will be point to same bucket,
now equals method will be used to compare them which will return true.
This is the reason java doc says “if you override equals() method then you must override hashCode() method”


Key points to remember:
    1. If you are overriding equals method then you should override hashcode() also.
    2. If two objects are equal then they must have same hashcode.
    3. If two objects have same hashcode then they may or may not be equal
    4. Always use same attributes to generate equals and hashcode as in our case we have used name.

The equals method implements an equivalence relation on non-null object references:
    * It is reflexive: for any non-null reference value x, x.equals(x) should return true.
    * It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
    * It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true,
        then x.equals(z) should return true.
    * It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false,
     provided no information used in equals comparisons on the objects is modified.
    * For any non-null reference value x, x.equals(null) should return false.
hashcode():
    * Whenever it is invoked on the same object more than once during an execution of a Java application,
     the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified.
     This integer need not remain consistent from one execution of an application to another execution of the same application.
    * If two objects are equal according to the equals(Object) method,
     then calling the hashCode method on each of the two objects must produce the same integer result.
    * It is not required that if two objects are unequal according to the equals(java.lang.Object) method,
     then calling the hashCode method on each of the two objects must produce distinct integer results.
     However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
 */

import java.util.HashMap;
import java.util.Iterator;

// This country class have two basic attributes- name and population.
class Country {
    String name;
    long population;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}

// Now create a class called “EqualsHashcode.java”
public class EqualsHashcode {
    public static void main(String[] args) {
        Country c1 = new Country();
        c1.setName("India");
        Country c2 = new Country();
        c2.setName("India");

        System.out.println("Is c1.equals(c2)? " + c1.equals(c2));
        System.out.println("-------------");

        HashMap<Country,String> countryCapitalMap = new HashMap<Country,String>();

        countryCapitalMap.put(c1, "Delhi");
        countryCapitalMap.put(c2, "Delhi");

        Iterator countryCapitalIter = countryCapitalMap.keySet().iterator();
        while(countryCapitalIter.hasNext()) {
            Country countryObj = (Country) countryCapitalIter.next();
            String capital = countryCapitalMap.get(countryObj);
            System.out.println("Capital of "+ countryObj.getName() + "----" + capital);
        }
    }
}
