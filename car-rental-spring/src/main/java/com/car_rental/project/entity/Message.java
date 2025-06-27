package com.car_rental.project.entity;

public class Message {

    private String message ;



    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Responses{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
