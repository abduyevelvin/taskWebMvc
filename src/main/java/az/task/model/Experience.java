package az.task.model;

public class Experience {

    private int id_experience, active;
    private String experience;

    public int getId_experience() {
        return id_experience;
    }

    public void setId_experience(int id_experience) {
        this.id_experience = id_experience;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id_experience=" + id_experience +
                ", active=" + active +
                ", experience='" + experience + '\'' +
                '}';
    }
}
