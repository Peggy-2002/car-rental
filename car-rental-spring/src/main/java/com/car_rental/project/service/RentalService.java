package com.car_rental.project.service;

import com.car_rental.project.entity.*;

import java.util.List;

public interface RentalService {
    String  saveSignUp(SignUp signUp);

    SignUp verifyEmailAndPassword(Login login);

    void addComplaint(Complaints complaints);
    void returnCar(BookingForm bookingForm);

    void addCar(Cars car);

    List<Cars> getCars();
    List<Complaints> getComplaints();
    Cars getCar(String name);
    void removeCar(String name);

    void saveBookingForm(BookingForm bookingForm);

    void saveForm(BookingForm bookingForm);

    void updateCar(Cars car);

    List<BookingForm> getAllBooking();

    BookingForm getBooking(int license);

    void update(BookingForm bookingForm);

    void editBooking(int license ,BookingForm bookingForm);

}
