package az.task.model;

import java.util.Arrays;

public class Employee {

    private int id_employee, age, active, city_id, experience_id;
    private String name, surname, job_title, city_name, experience_name;
    private City city;
    private Experience experience;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(int experience_id) {
        this.experience_id = experience_id;
    }

    public String getExperience_name() {
        return experience_name;
    }

    public void setExperience_name(String experience_name) {
        this.experience_name = experience_name;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", age=" + age +
                ", active=" + active +
                ", city_id=" + city_id +
                ", experience_id=" + experience_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", job_title='" + job_title + '\'' +
                ", city_name='" + city_name + '\'' +
                ", experience_name='" + experience_name + '\'' +
                ", city=" + city +
                ", experience=" + experience +
                '}';
    }
}
