/**
 * Given a list of people with their birth and death years,
 * implement a method to compute the year with the most number of people alive.
 * You may assume that all people were born between 1900 and 2000 (inclusive).
 * If a person was alive during any portion of that year, they should be included in that year's count.
 * For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909
 */
public class LivingPeople {

    public static class Person {
        String name;
        int yearOfBirth;
        int yearOfDeath;

        public Person(String name, int yearOfBirth, int yearOfDeath) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
            this.yearOfDeath = yearOfDeath;
        }

        public int getYearOfBirth() {
            return yearOfBirth;
        }

        public int getYearOfDeath() {
            return yearOfDeath;
        }
    }

    static int yearWithHighestPopulation(Person[] persons) {
        if(persons.length == 0)
            return - 1;
        int[] years = new int[102];
        for(Person person: persons) {
            years[person.getYearOfBirth() - 1900] ++;
            years[person.getYearOfDeath() + 1 - 1900] --;
        }

        int maxPopulationIdx = -1;
        int maxPopulationCount = 0;
        int countPopulation = 0;
        for(int i = 0; i < years.length; i++) {
            countPopulation += years[i];
            if(maxPopulationCount < countPopulation) {
                maxPopulationCount = countPopulation;
                maxPopulationIdx = i;
            }
        }
        return maxPopulationIdx + 1900;
    }

    /**
     * this is a different scenario - in case where there is no limit of years  (e.g 1900-2000)
     * need to build a range between lowest birth year to highest death year
     * and basically do the same as in yearWithHighestPopulation
     */
    static int yearWithHighestPopulationWithoutYearsLimit(Person[] persons) {
        if(persons.length == 0)
            return - 1;
        int minRange = Integer.MAX_VALUE;
        int maxRange = 0;
        for (Person person : persons) {
            if (person.getYearOfBirth() < minRange)
                minRange = person.getYearOfBirth();
            if (person.getYearOfDeath() > maxRange)
                maxRange = person.getYearOfDeath();
        }

        int[] years = new int[maxRange - minRange + 2];
        for (Person p : persons) {
            years[p.getYearOfBirth() - minRange]++;
            years[p.getYearOfDeath() - minRange + 1]--;
        }
        int maxPopultedYear = 0;
        int sumPopulation = 0;
        int maxPopulation = 0;
        for (int i = 0; i < years.length; i++) {
            sumPopulation += years[i];
            if (sumPopulation > maxPopulation) {
                maxPopulation = sumPopulation;
                maxPopultedYear = i + minRange;
            }
        }
        return maxPopultedYear;
    }


    public static void main(String[] args) {
        Person[] persons = {
                new Person("1", 1920, 1980),
                new Person("1", 1910, 1956),
                new Person("1", 1960, 2000),
                new Person("1", 1959, 1999),
                new Person("1", 1910, 1976),
                new Person("1", 1934, 1980),
                new Person("1", 1944, 1988),
                new Person("1", 1900, 1976),
        };
        int res = yearWithHighestPopulation(persons);
        System.out.println("1: at 1934 lived more people : " + (res == 1960));

        // maximum 2 lives at same time in 1910,1925,1970,1979. will return first two = 1910
        Person[] persons2 = {
                new Person("1", 1900, 1910),
                new Person("1", 1910, 1920),
                new Person("1", 1920, 1930),
                new Person("1", 1925, 1935),
                new Person("1", 1940, 1950),
                new Person("1", 1965, 1975),
                new Person("1", 1970, 1980),
                new Person("1", 1979, 1990),
        };
        int res2 = yearWithHighestPopulation(persons2);
        System.out.println("2: at 1925 lived more people : " + (res2 == 1910));

        Person[] persons3 = {
                new Person("1", 1900, 2000),
                new Person("1", 1910, 2000),
                new Person("1", 1920, 2000),
                new Person("1", 1925, 2000),
                new Person("1", 1940, 2000),
                new Person("1", 1965, 2000),
                new Person("1", 1970, 2000),
                new Person("1", 1979, 2000),
        };
        int res3 = yearWithHighestPopulation(persons3);
        System.out.println("3: at 1979 lived more people : " + (res3 == 1979));

        Person[] persons4 = {
                new Person("1", 1750, 1820),
                new Person("1", 2000, 2020),
                new Person("1", 1900, 1980),
                new Person("1", 1820, 1900),
                new Person("1", 1999, 2040),
                new Person("1", 1982, 2050),
                new Person("1", 1900, 1960),
                new Person("1", 1780, 1820),
        };
        int res4 = yearWithHighestPopulationWithoutYearsLimit(persons4);
        System.out.println("3: at 1820 lived more people : " + (res4 == 1820));
    }

}
