package com.car_rental.project.entity;

import jakarta.persistence.*;




@Entity
@Table(name="bookings")
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = {CascadeType.REFRESH})
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

    @Column(name="cancel_status")
    private String status;

//    @Column(name="return_status")
//    private String returnStatus;

    @Column(name="cancellation_fee")
    private int cancelationFee;


    @Column(name="drop_of_date")
    private String dropOfDate;
    @Column(name="condition_status")
    private String condition;

    @Column(name="returned_on_time")
    private String time;

    @Column(name="return_status")
    private String returned;
    @Column(name="damaged_fee")
    private int damagedFee;
    @Column(name="delayed_fee")
    private int delayedFee;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SignUp getSignUp() {
        return signUp;
    }

    public void setSignup(SignUp signUp) {
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

    public int getDamagedFee() {
        return damagedFee;
    }

    public void setDamagedFee(int damagedFee) {
        this.damagedFee = damagedFee;
    }

    public int getDelayedFee() {
        return delayedFee;
    }

    public void setDelayedFee(int delayedFee) {
        this.delayedFee = delayedFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getReturnStatus() {
//        return returnStatus;
//    }
//
//    public void setReturnStatus(String returnStatus) {
//        this.returnStatus = returnStatus;
//    }


    public int getCancelationFee() {
        return cancelationFee;
    }

    public void setCancelationFee(int cancelationFee) {
        this.cancelationFee = cancelationFee;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
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
                ", status='" + status + '\'' +
                ", cancelationFee=" + cancelationFee +
                ", dropOfDate='" + dropOfDate + '\'' +
                ", condition='" + condition + '\'' +
                ", time='" + time + '\'' +
                ", returned='" + returned + '\'' +
                ", damagedFee=" + damagedFee +
                ", delayedFee=" + delayedFee +
                '}';
    }
}
