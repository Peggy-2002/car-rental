package com.car_rental.project.entity;

import jakarta.persistence.*;




@Entity
@Table(name="bookings")
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="account_id")
    private SignUp signUp ;

    @Column(name = "name")
    private  String name ;
    @Column(name = "surname")
    private  String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "drivers_license")
    private int license;
    @Column(name = " car_name")
    private String carName;


    @Column(name="pick_up_date")
    private String pickUpDate;


    @Column(name="drop_of_date")
    private String dropOfDate;

    @Column(name="payment")
    private String payment;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SignUp getSignUp() {
        return signUp;
    }

    public void setUser(SignUp signUp) {
        this.signUp = signUp;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setSignUp(SignUp signUp) {
        this.signUp = signUp;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOfDate() {
        return dropOfDate;
    }

    public void setDropOfDate(String dropOfDate) {
        this.dropOfDate = dropOfDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "BookingForm{" +
                "id=" + id +
                ", signUp=" + signUp +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", license=" + license +
                ", carName='" + carName + '\'' +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", dropOfDate='" + dropOfDate + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
