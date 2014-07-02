package com.rightmove;

import java.io.IOException;
import java.text.DecimalFormat;

public class DataApplication {

    private PersonRepository personRepository = PersonCSVFileRepository.getInstance("manipulate-data.txt");

    public static void main(String[] args) throws IOException {
        DataApplication dataApplication = new DataApplication();
        System.out.println("No of males: " + dataApplication.getNoOfMales());
        System.out.println("Average age: " + dataApplication.getAverageAge());
        System.out.println("Age difference (days): " + dataApplication.getNoOfDaysDifference("Bill Johnson", "Tom Soyer"));
    }

    public int getNoOfMales() {
        return personRepository.getNoOfPeople(Sex.MALE);
    }

    public String getAverageAge() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(personRepository.getAverageAge());
    }

    public Long getNoOfDaysDifference(String personName1, String personName2) {
        if (personName1 == null || personName1.isEmpty()) {
            throw new IllegalArgumentException("personName1 parameter is required");
        }
        if (personName2 == null || personName2.isEmpty()) {
            throw new IllegalArgumentException("personName2 parameter is required");
        }
        try {
            Person person1 = personRepository.getPersonByName(personName1);
            Person person2 = personRepository.getPersonByName(personName2);
            if (person1.getDateOfBirth() != null && person2.getDateOfBirth() != null) {
                long diff = person1.getDateOfBirth().getTimeInMillis() - person2.getDateOfBirth().getTimeInMillis();
                return diff / (1000 * 60 * 60 * 24);
            } else {
                throw new IllegalStateException("Persons don't have a date of birth!");
            }
        } catch (PersonNotFoundException ex) {
            System.out.println("Person " + ex.getPersonName() + " could not be found in the system!");
            return null;
        }
    }

}
