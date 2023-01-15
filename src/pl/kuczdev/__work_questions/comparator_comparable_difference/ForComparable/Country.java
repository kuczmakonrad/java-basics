package pl.kuczdev.__work_questions.comparator_comparable_difference.ForComparable;

public class Country implements Comparable{
    int id;
    String name;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //If this.countryId < country.countryId:then compare method will return -1
    //If this.countryId > country.countryId:then compare method will return 1
    //If this.countryId == country.countryId:then compare method will return 0
    @Override
    public int compareTo(Object o) {
        Country country = (Country) o;
        return Integer.compare(this.id, country.id);
        //same is
        // return (this.id < country.id) ? -1 : (this.id > country.id) ? 1 : 0;
    }
}