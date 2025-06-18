package com.car_rental.project.entity;

import jakarta.persistence.*;




@Entity
@Table(name="accounts")
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToOne(mappedBy="signUp", cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private BookingForm bookingForm;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;


    public SignUp() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public void setSurname(String lastName) {
        this.surname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email != null ?
                email.trim() :null;

    }



    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password != null?
                password.trim() : null;
    }

    public BookingForm getBookingForm() {
        return bookingForm;
    }

    public void setBookingForm(BookingForm bookingForm) {
        this.bookingForm = bookingForm;
        bookingForm.setSignUp(this);
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "id=" + id +
                ", bookingForm=" + bookingForm +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

