package com.car_rental.project.service;

import com.car_rental.project.entity.*;
import com.car_rental.project.repository.RentalRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl  implements RentalService{

    List<Cars> car = new ArrayList<>();

    @Autowired
    private JavaMailSender mailSender;
    final private RentalRepositoryImpl rentalRepository;
@Autowired
    public RentalServiceImpl(RentalRepositoryImpl rentalRepository){
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public String   saveSignUp(SignUp signUp) {
            return this.rentalRepository.saveSignUp(signUp);
    }

    @Override
    public SignUp verifyEmailAndPassword(Login login) {

            return this.rentalRepository.verifyEmailAndPassword(login);



    }

    @Override
    @Transactional
    public void addComplaint(Complaints complaints) {
    rentalRepository.addComplaint(complaints);

    }

    @Override
    @Transactional
    public void addCar(Cars car) {
    this.rentalRepository.addCar(car);

    }

    @Override
    public List<Cars> getCars() {
        List<Cars> cars =  this.rentalRepository.getCars();
        this.car = cars;
        return  cars;
    }

    @Override
    public List<Complaints> getComplaints() {
    return this.rentalRepository.getComplaints();
    }

    @Override
    @Transactional
    public Cars getCar(String name) {
        return this.rentalRepository.getCar(name);
    }

    @Override
    @Transactional
    public void removeCar(String name) {
        this.rentalRepository.removeCar(name);
    }

    @Transactional
    public void saveBookingForm(BookingForm bookingForm ) {
    for(int i =0 ;i < this.car.size(); i++){
        if(bookingForm.getCarName().equals(this.car.get(i).getName())){
            SimpleMailMessage message= new SimpleMailMessage();
            message.setFrom ("peggydudu5@gmail.com");
            message.setTo(bookingForm.getEmail());
            message.setSubject("Car booking confirmation");
            message.setText( "Hi  " + bookingForm.getName() + ",\n\n" +
                    "Booking Code: " + bookingForm.getLicense() + "\n\n" +
                    "This is to confirm your booking for the vehicle:  " + bookingForm.getCarName() + "\n" +
                    "Price" + this.car.get(i).getStatus() + "\n" +
                    "Seater" + this.car.get(i).getSeater() + "\n" +
                    "Picture" + this.car.get(i).getPicture() + "\n" +
                    "Pick-up Date: " + bookingForm.getPickUpDate() + "\n" +
                    "Location:Klerksdorp " + "\n\n" +
                    "If you  need to make any changes, please use your booking code to update your reservation  on our  website.\n" +
                    "Should you  you have any questions, feel free to contact us.\n\n" +
                    "We looking forward to serving  you.\n\n" +
                    "Best regards,\n" +
                    "Peggy");


            mailSender.send(message);


        }
       updateCars(this.car.get(i));
    }
//        SimpleMailMessage message= new SimpleMailMessage();
//        message.setFrom ("peggydudu5@gmail.com");
//        message.setTo(bookingForm.getEmail());
//        message.setSubject("Car booking confirmation");
//        message.setText( "Hi  " + bookingForm.getName() + ",\n\n" +
//                          "Booking Code: " + bookingForm.getLicense() + "\n\n" +
//                          "This is to confirm your booking for the vehicle:  " + bookingForm.getCarName() + "\n" +
//
//                           "Pick-up Date: " + bookingForm.getPickUpDate() + "\n" +
//                            "Location:Klerksdorp " + "\n\n" +
//                             "If you  need to make any changes, please use your booking code to update your reservation  on our  website.\n" +
//                               "Should you  you have any questions, feel free to contact us.\n\n" +
//                                 "We looking forward to serving  you.\n\n" +
//                                    "Best regards,\n" +
//                                      "Peggy");
//
//
//        mailSender.send(message);


    this.rentalRepository.saveBookingForm(bookingForm);

    }




    @Transactional
    public void saveForm(BookingForm bookingForm) {

        for(int i =0 ;i < this.car.size(); i++){
            if(bookingForm.getCarName().equals(this.car.get(i).getName())){
                SimpleMailMessage message= new SimpleMailMessage();
                message.setFrom ("peggydudu5@gmail.com");
                message.setTo(bookingForm.getEmail());
                message.setSubject("Car booking confirmation");
                message.setText( "Hi  " + bookingForm.getName() + ",\n\n" +
                        "Booking Code: " + bookingForm.getLicense() + "\n\n" +
                        "This is to confirm your booking for the vehicle:  " + bookingForm.getCarName() + "\n" +
                        "Price" + this.car.get(i).getStatus() + "\n" +
                        "Seater" + this.car.get(i).getSeater() + "\n" +
                        "Picture" + this.car.get(i).getPicture() + "\n" +
                        "Pick-up Date: " + bookingForm.getPickUpDate() + "\n" +
                        "Location:Klerksdorp " + "\n\n" +
                        "If you  need to make any changes, please use your booking code to update your reservation  on our  website.\n" +
                        "Should you  you have any questions, feel free to contact us.\n\n" +
                        "We looking forward to serving  you.\n\n" +
                        "Best regards,\n" +
                        "Peggy");


                mailSender.send(message);


            }
            updateCars(this.car.get(i));
        }






//        SimpleMailMessage message= new SimpleMailMessage();
//        message.setFrom ("peggydudu5@gmail.com");
//        message.setTo(bookingForm.getEmail());
//        message.setSubject("Car booking confirmation");
//        message.setText( "Hi  " + bookingForm.getName() + ",\n\n" +
//                "Booking Code: " + bookingForm.getLicense() + "\n\n" +
//                "This is to confirm your booking for the vehicle:  " + bookingForm.getCarName() + "\n" +
//                "Pick-up Date: " + bookingForm.getPickUpDate() + "\n" +
//                "Location:Klerksdorp " + "\n\n" +
//                "If you  need to make any changes, please use your booking code to update your reservation  on our  website.\n" +
//                "Should you  you have any questions, feel free to contact us.\n\n" +
//                "We looking forward to serving  you.\n\n" +
//                "Best regards,\n" +
//                "Peggy");
//
//
//        mailSender.send(message);


        this.rentalRepository.saveForm(bookingForm);

    }
//    @Override
//    @Transactional
//    public void updateCars(Cars ) {
//        this.rentalRepository.updateCar(car);
//
//    }

        @Transactional
        public void updateCars(Cars car) {
          this.rentalRepository.updateCars(car);

}
    @Override
    @Transactional
    public void updateCar(Cars car) {
    this.rentalRepository.updateCar(car);

    }

    @Override
    public List<BookingForm> getAllBooking() {
        return rentalRepository.findAll();
    }

    @Override
    public BookingForm getBooking(int license) {
        return rentalRepository.findByDriversLicense(license) ;
    }

    @Override
    @Transactional
    public void update(BookingForm bookingForm) {
        rentalRepository.update(bookingForm);
    }

    @Override
    @Transactional
    public void editBooking(int license, BookingForm bookingForm) {
    BookingForm existingBooking = rentalRepository.findByDriversLicense(license);
    if(existingBooking !=null){
        existingBooking.setName(bookingForm.getName());
        existingBooking.setSurname(bookingForm.getSurname());
        existingBooking.setEmail(bookingForm.getEmail());
        existingBooking.setPickUpDate(bookingForm.getPickUpDate());
        existingBooking.setDropOfDate(bookingForm.getDropOfDate());
        existingBooking.setCarName(bookingForm.getCarName());
        rentalRepository.editBooking(existingBooking);
    }

    }

    @Override
    @Transactional
    public void returnCar(int license) {
    rentalRepository.updateCarStatus(license);


    }






}
