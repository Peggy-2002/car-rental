package com.car_rental.project.controller;

import com.car_rental.project.entity.*;
import com.car_rental.project.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentalController {

final private  RentalService rentalService;
    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @PostMapping("/signUp")
    public Message signUp(@RequestBody SignUp signUp) {
        String string = this.rentalService.saveSignUp(signUp);
        System.out.println(string);
        Message messages = new Message();
        messages.setMessage("successfully created account");
        Message message = new Message();
        message.setMessage("Password already in use please into new password");


        if (!string.equals("persisted")) {
            return message;

        } else {
            return messages;
        }
    }


    @PostMapping("/login")
    public Response getUser(@RequestBody Login login) {
        System.out.println(login.getEmail());
        System.out.println(login.getPassword());
        SignUp   role = this.rentalService.verifyEmailAndPassword(login);
        Response responses = new Response();
        responses.setMessage(role.getRole());
        responses.setId(role.getId());
        System.out.println(role.getId());
        System.out.println(role.getRole());
        return responses;

    }

    @PostMapping("addCar")
    public Response addCar(@RequestBody Cars car ){
        System.out.println(car);

        this.rentalService.addCar(car);
        Response responses = new Response();
        responses.setMessage("Car added");

        return responses;

    }

    @GetMapping("/getCars")
    public List<Cars> getCars(){
         List<Cars>  cars =this.rentalService.getCars();
        System.out.println(cars);
        return cars;


    }

    @GetMapping("/searchCar/{name}")
    public Cars  getCar(final @PathVariable String  name){
        Cars car = this.rentalService.getCar(name);
        System.out.println(name);
        return car;


    }
    @PatchMapping("/updateCar")
    public Response getCar(@RequestBody Cars car){
        this.rentalService.updateCar(car);
        System.out.println(car);
        Response response = new Response();
        response.setMessage("Car Updated");
        return response;


    }


    @DeleteMapping("/removeCar/{name}")
    public Response removeCar(final @PathVariable String name){
        System.out.println(name);
        this.rentalService.removeCar(name);
        Response response = new Response();
        response.setMessage("Removed");

        return response;

    }


    @PostMapping("/booking")
    public Response saveBookingForm(@RequestBody BookingForm bookingForm ){
        System.out.println(bookingForm);


        this.rentalService.saveBookingForm(bookingForm);
        Response response = new Response();
        response.setMessage("submitted");

        return response;

    }

    @PostMapping("/bookings")
    public Response saveForm(@RequestBody BookingForm bookingForm ){
        System.out.println(bookingForm);
        int  id = bookingForm.getSignUp().getId();
        System.out.println(id);

        this.rentalService.saveForm(bookingForm);
        Response response = new Response();
        response.setMessage("submitted");

        return response;

    }

    @GetMapping("/viewbookings")
    public List<BookingForm> getAllBookings(){
        List<BookingForm> booking = rentalService.getAllBooking();
        System.out.println(booking);
        return booking;
    }

    @GetMapping("bookings/{license}")
    public  BookingForm getBooking(final  @PathVariable int license){
        return rentalService.getBooking(license);
    }
    @PostMapping("/update-bookings")
    public  Response  deleteBookings(@RequestBody BookingForm bookingForm){
        rentalService.update(bookingForm);
        System.out.println(bookingForm);
        Response response = new Response();
        response.setMessage("Cancelled");
        return  response;

    }

    @PutMapping("/editBooking/{license}")
    public  void  editBooking(@PathVariable int  license, @RequestBody BookingForm bookingForm){
        rentalService.editBooking(license,bookingForm);
    }


}
