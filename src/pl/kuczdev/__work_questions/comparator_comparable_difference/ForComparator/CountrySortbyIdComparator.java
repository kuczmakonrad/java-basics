package pl.kuczdev.__work_questions.comparator_comparable_difference.ForComparator;

import java.util.Comparator;
//If country1.getCountryId()<country2.getCountryId():then compare method will return -1
//If country1.getCountryId()>country2.getCountryId():then compare method will return 1
//If country1.getCountryId()==country2.getCountryId():then compare method will return 0
public class CountrySortbyIdComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Country c1 = (Country) o1;
        Country c2 = (Country) o2;
        return Integer.compare(c1.countryId, c2.countryId);
        // same is:
        // return (country1.getCountryId() < country2.getCountryId() ) ? -1: (country1.getCountryId() > country2.getCountryId() ) ? 1:0 ;
    }
}
