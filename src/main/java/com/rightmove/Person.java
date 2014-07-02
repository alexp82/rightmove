/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rightmove;

import java.util.Calendar;

/**
 *
 * @author alexp
 */
public class Person {

    private final String fullName;
    private final Sex sex;
    private final Integer age;
    private final Calendar dateOfBirth;

    public Person(String fullName, Sex sex, Integer age, Calendar dateOfBirth) {
        this.fullName = fullName;
        this.sex = sex;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public Sex getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.fullName != null ? this.fullName.hashCode() : 0);
        hash = 71 * hash + (this.sex != null ? this.sex.hashCode() : 0);
        hash = 71 * hash + (this.age != null ? this.age.hashCode() : 0);
        hash = 71 * hash + (this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.fullName == null) ? (other.fullName != null) : !this.fullName.equals(other.fullName)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (this.age != other.age && (this.age == null || !this.age.equals(other.age))) {
            return false;
        }
        if (this.dateOfBirth != other.dateOfBirth && (this.dateOfBirth == null || !this.dateOfBirth.equals(other.dateOfBirth))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "fullName=" + fullName + ", sex=" + sex + ", age=" + age + ", dateOfBirth=" + dateOfBirth + '}';
    }

}
