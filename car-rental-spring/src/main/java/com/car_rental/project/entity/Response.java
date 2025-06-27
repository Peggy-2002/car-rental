package com.car_rental.project.entity;

public class Response {

    private String message ;

    private  String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
