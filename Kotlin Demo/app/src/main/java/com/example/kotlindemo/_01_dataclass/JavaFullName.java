package com.example.kotlindemo._01_dataclass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class JavaFullName {

    private String firstName;
    private String lastName;

    public JavaFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode()*1000+lastName.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj instanceof JavaFullName) {
            JavaFullName otherObj = (JavaFullName) obj;
            return Objects.equals(firstName, otherObj.firstName)
                    && Objects.equals(lastName, otherObj.lastName);
        } else
            return false;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new JavaFullName(firstName, lastName);
    }

    @NonNull
    @Override
    public String toString() {
        return JavaFullName.class.getSimpleName()+"("+"firstName="+firstName +", "+ "lastName="+lastName+")";
    }
}
