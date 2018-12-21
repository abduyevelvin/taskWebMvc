package az.task.model;

public class City {

    private int id_city, active;
    private String city;

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id_city=" + id_city +
                ", active=" + active +
                ", city='" + city + '\'' +
                '}';
    }
}
