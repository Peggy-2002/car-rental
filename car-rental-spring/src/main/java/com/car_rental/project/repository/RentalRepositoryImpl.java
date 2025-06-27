package com.car_rental.project.repository;

import com.car_rental.project.entity.*;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class RentalRepositoryImpl implements  RentalRepository {
    String message;

    private EntityManager entityManager;

    public RentalRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public String saveSignUp(SignUp signUp) {

        try {

            SignUp signUp1 = new SignUp();
            signUp1.setName(signUp.getName());
            signUp1.setSurname(signUp.getSurname());
            signUp1.setEmail(signUp.getEmail());
            signUp1.setPassword(signUp.getPassword());
            signUp1.setRole("Manager");
            this.entityManager.persist(signUp1);


        } catch (PersistenceException e) {
            if (e.getCause() instanceof SQLException) {
                SQLException sqlException = (SQLException) e.getCause();
                if (sqlException.getErrorCode() == 1062) {
                    message = "Password in use please enter new password";

                }
            }
            System.out.println(message);
        }
        return message;


    }

    @Override
    public SignUp verifyEmailAndPassword(Login login) {

            TypedQuery<SignUp> typedQuery = entityManager.createQuery("FROM SignUp   WHERE email=:theData and password = :password" ,SignUp.class);
            typedQuery.setParameter("theData",login.getEmail());
            typedQuery.setParameter("password",login.getPassword());

            return typedQuery.getSingleResult();


    }

    @Override
    public void addCar(Cars car) {
        this.entityManager.persist(car);

    }

    @Override
    public void addComplaint(Complaints complaints) {
        entityManager.persist(complaints);

    }

    public List<Cars> getCars(){

            TypedQuery<Cars> typedQuery = entityManager.createQuery("FROM Cars",Cars.class);

            return typedQuery.getResultList();

    }

    @Override
    public void returnCar(BookingForm bookingForm) {
       BookingForm bookingForm1 = findByDriversLicense(bookingForm.getLicense());
       bookingForm1.setReturned(bookingForm.getReturned());
       bookingForm1.setTime(bookingForm.getTime());
       bookingForm1.setCondition(bookingForm.getCondition());
       bookingForm1.setDelayedFee(bookingForm.getDelayedFee());
       bookingForm1.setDamagedFee(bookingForm.getDamagedFee());
       bookingForm1.setReturned("Returned");
       entityManager.merge(bookingForm1);

    }

    @Override
    public void updateCars(Cars car) {
        Cars  cars = entityManager.find(Cars.class,car.getId());
        cars.setName(car.getName());
        cars.setPicture(car.getPicture());
        cars.setSeater(car.getSeater());
        cars.setStatus("Booked");

        entityManager.merge(cars);



    }

    @Override
    public void updateReturnedCar(Cars car) {
        Cars ca = entityManager.find(Cars.class,car.getId());
        ca.setStatus("Available");
        entityManager.merge(ca);
    }

    @Override
    public List<Complaints> getComplaints() {
        TypedQuery<Complaints> typedQuery = entityManager.createQuery("FROM Complaints",Complaints.class);

        return typedQuery.getResultList();


    }

    @Override
    public Cars getCar(String name) {
            Cars car = entityManager.createQuery("Select   a From   Cars a  where a.name = :data", Cars.class)
                    .setParameter("data", name).getSingleResult();


            return car;
        }

    @Override
    public void removeCar(String name) {
        Cars car = entityManager.createQuery("Select   a From   Cars a  where a.name = :data", Cars.class)
                .setParameter("data", name).getSingleResult();
        entityManager.remove(car);


    }


    public  void saveBookingForm(BookingForm bookingForm ){

        this.entityManager.persist(bookingForm);
    }

    public  void saveForm(BookingForm bookingForm ){

        entityManager.merge(bookingForm);
    }

    @Override
    public void updateCar(Cars car) {
        Cars  cars = entityManager.find(Cars.class,car.getId());
        cars.setName(car.getName());
        cars.setPicture(car.getPicture());
        cars.setSeater(car.getSeater());
        cars.setStatus(car.getStatus());

        entityManager.merge(cars);


//        Cars cars = new Cars();
//        cars.setName(car.getName());
//        cars.setPicture(car.getPicture());
//         cars.setSeater(car.getSeater());
//         cars.setStatus(car.getStatus());
//         cars.setId(car.getId());
//        this.entityManager.persist(cars);

    }

    @Override
    public List<BookingForm> findAll() {
//        return entityManager.createQuery("SELECT b FROM BookingForm b ", BookingForm.class).getResultList();

    TypedQuery<BookingForm> typedQuery = entityManager.createQuery("FROM BookingForm", BookingForm.class);
        System.out.println(typedQuery.getResultList());

    return typedQuery.getResultList();

    }

    @Override
    public BookingForm findByDriversLicense(int license) {
        TypedQuery<BookingForm> query =entityManager.createQuery("FROM BookingForm WHERE license =:license", BookingForm.class);
        query.setParameter("license",license);

        BookingForm booking = query.getSingleResult();
        System.out.println(license);
        System.out.println(booking );
        return booking ;
    }

    @Override
    public void update(BookingForm bookingForm) {

            BookingForm bookingForm1 =findByDriversLicense(bookingForm.getLicense());

                    bookingForm1.setStatus("Cancelled");
            entityManager.merge(bookingForm1);


        }







    @Override
    public void editBooking(BookingForm bookingForm) {
        BookingForm booking = findByDriversLicense(bookingForm.getLicense());
        entityManager.merge(booking);
    }

    @Override
    public Cars findById(int id) {
        return entityManager.find(Cars.class,id);
    }

    @Override
    public void save(Cars cars) {
        entityManager.merge(cars);

    }

//    @Override
//    public void updateCarStatus(int license) {
//        Query query = entityManager.createQuery("UPDATE  BookingForm  b SET  b.returnDate = :CURRENT_DATE WHERE.license =:license ");
//        query.setParameter("license",license);
//
//
//    }



}







