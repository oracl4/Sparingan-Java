package sparingan_java;

import java.util.ArrayList;

public abstract class User {
    private String name, location, phoneNumber, password,email;
    private int id;
    private Rating rating;
    private Schedule userSchedules;
    private UserType userType;

    private boolean isScheduled;

    public boolean getIsScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean status) {
        this.isScheduled = status;
    }

    public User(String name, String location, String phoneNumber, String password, String email) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.isScheduled=false;
        this.id = DatabaseUser.getLastUserId() + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Schedule getUserSchedules() {
        return userSchedules;
    }

    public void setUserSchedules(Schedule userSchedules) {
        this.userSchedules = userSchedules;
    }

    public abstract String toString();

    //public abstract void addMember();

    //public abstract void removeMember();

    /*public Sport getSport() {
        return sport;
    }*/

    /*public void setSport(Sport sport) {
        this.sport = sport;
    }*/
}
