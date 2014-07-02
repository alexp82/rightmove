/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author alexp
 */
public class CSVSerializer {

    private String fileLocation;
    private boolean firstLineHeader = true;
    private String separator = ",";
    private String dateFormat = "dd/M/yyyy";
    private SimpleDateFormat sdf;

    public CSVSerializer(String fileLocation) {
        this.fileLocation = fileLocation;
        this.sdf = new SimpleDateFormat(dateFormat);
    }

    public CSVSerializer(String fileLocation, boolean firstLineHeader, String separator, String dateFormat) {
        this.firstLineHeader = firstLineHeader;
        this.separator = separator;
        this.dateFormat = dateFormat;
        this.sdf = new SimpleDateFormat(dateFormat);
    }

    /**
     Here a solution based on reflection could be used to make the CSVSerializer independent of the type of the object being serialized/deserialized
     @return
     @throws IOException
     */
    public Set<Person> loadData() throws IOException {
        File file = new File(fileLocation);
        if (file.exists()) {
            System.out.println(file.getName() + " file exists = " + file.exists());
            return deserialize(file);
        } else {
            throw new FileNotFoundException(file.getName() + " could not be found in the system!");
        }

    }

    private Set<Person> deserialize(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        if (firstLineHeader) {
            line = bufferedReader.readLine();
            if (line != null) {
                System.out.println(file.getName() + " header: " + line);
            }
        }
        Set<Person> persons = new LinkedHashSet<Person>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] columns = line.split(separator);
            Person person = new Person(columns[0].trim(), Sex.fromString(columns[1].trim()), Integer.valueOf(columns[2].trim()), getDateFromString(columns[3].trim()));
            persons.add(person);
        }
        bufferedReader.close();
        return persons;
    }

    private Calendar getDateFromString(String strDate) {
        if (strDate == null || strDate.isEmpty()) {
            throw new IllegalArgumentException("String " + strDate + " is empty");
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(strDate));
            return calendar;
        } catch (ParseException ex) {
            throw new IllegalArgumentException("String " + strDate + " has a wrong date format. " + ex.getMessage());
        }
    }

    public boolean isFirstLineHeader() {
        return firstLineHeader;
    }

    public String getSeparator() {
        return separator;
    }

    public String getDateFormat() {
        return dateFormat;
    }

}
