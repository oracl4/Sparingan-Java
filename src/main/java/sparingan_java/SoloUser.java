package sparingan_java;

public class SoloUser extends User {

    public SoloUser(String name, String location, String phoneNumber, String password, String email){
        super(name, location, phoneNumber, password, email);
    }

    public String toString() {
        return "User \n{" +
                "name='" + getName() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", id=" + getId() +
                ", userSchedules=" + getUserSchedules() +
                ", isScheduled=" + getIsScheduled() +
                '}';
    }
}
