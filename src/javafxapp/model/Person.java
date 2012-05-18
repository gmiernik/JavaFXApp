/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.model;


/**
 *
 * @author Miernik
 */
public class Person {
 
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Person() {
    }    
}
