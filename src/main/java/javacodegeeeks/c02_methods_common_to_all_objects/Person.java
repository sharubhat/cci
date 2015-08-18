package javacodegeeeks.c02_methods_common_to_all_objects;

import java.util.Objects;

/**
 * Created by sharath on 7/31/15.
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(final String fName, final String lName, final String eMail) {
        this.firstName = fName;
        this.lastName = lName;
        this.email = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        if(this == obj)
            return true;

        if(getClass() != obj.getClass())
            return false;

        final Person another = (Person) obj;

        if(!Objects.equals(email, another.email))
            return false;
        else if(!Objects.equals(firstName, another.firstName))
            return false;
        else if(!Objects.equals(lastName, another.lastName))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format("%s[email=%s, first name=%s, last name=%s",
                getClass().getSimpleName(), getEmail(), getFirstName(), getLastName());
    }
}
