package Worck2;

import java.time.LocalDate;

public class Human {
    int age,weight;
    String firstName,lastName;
    LocalDate birthDate;
    Human (int age, String firstName, String lastName, LocalDate birthDate, int weight){
        this.age=age;
        this.birthDate=birthDate;
        this.firstName=firstName;
        this.lastName=lastName;
        this.weight=weight;
    };
    public int getWeight(){
        return weight;
    }
    public int getAge(){
        return age;
    }
    public String getFirstName(){
        return firstName;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
}
