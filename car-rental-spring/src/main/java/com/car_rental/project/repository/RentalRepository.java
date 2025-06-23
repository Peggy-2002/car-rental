package com.car_rental.project.repository;

import com.car_rental.project.entity.*;

import java.util.List;


public interface RentalRepository {
    String saveSignUp(SignUp signUp);
    SignUp verifyEmailAndPassword(Login login);
    void addCar(Cars car);

    void addComplaint(Complaints complaints);
    List<Cars> getCars();

    void returnCar(BookingForm bookingForm);

    void updateCars(Cars car);

    List<Complaints> getComplaints();
    Cars getCar(String name);
    void removeCar(String name);

   void  saveBookingForm(BookingForm bookingForm);

    void  saveForm(BookingForm bookingForm );

    void  updateCar(Cars car);

    List<BookingForm> findAll();

    BookingForm findByDriversLicense(int license);

    void update(BookingForm bookingForm);

    void editBooking(BookingForm bookingForm);
}
