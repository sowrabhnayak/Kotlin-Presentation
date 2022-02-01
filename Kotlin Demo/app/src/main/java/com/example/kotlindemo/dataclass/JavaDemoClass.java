package com.example.kotlindemo.dataclass;

public class JavaDemoClass {

    private String firstName;
    private String lastName;

    JavaDemoClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
