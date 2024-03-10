package C.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname cannot be empty")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 30 characters")
    @Column(name = "surname")
    private String surname;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+?(\\s\\w+), \\d{6}", message = "Your address should be in this format: Country, City, Postal code(6 digits)")
    @Column(name = "address")
    private String address; //Страна, Город, индекс(6 цифр)

    public Person(String name, String surname, int age, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Person(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Surname: " + surname;
    }
}