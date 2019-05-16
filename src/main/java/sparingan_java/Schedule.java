package sparingan_java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Schedule {
    private int id;

    private Sport sport;
    private Location location;
    private Calendar date;
    private User user1;
    private User user2;
    private boolean isActive;

    //Constructor Schedule, pertama-tama cuma masukin user yang bikin, nanti pas matching kalo match ya masukin user2
    public Schedule(Sport sport, Calendar date, Location location, User user1) {
        this.sport = sport;
        this.location = location;
        this.date = date;
        this.user1 = user1;
        id = DatabaseSchedule.getLastScheduleId() + 1;
        this.isActive = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public void setIsActive(boolean status){
        this.isActive = status;
    }

    public String toString() {
        String tempString;
        if(user2==null){
            tempString = "Not Yet";
        }
        else{
            tempString = user2.getName();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return "Schedule{" +
                "id=" + id +
                ", sport=" + sport.toString() +
                ", location=" + location.toString() +
                ", date=" + sdf.format(date.getTime()) +
                ", user1=" + user1.getName() +
                ", user2=" + tempString +
                ", isActive=" + isActive +
                '}';
    }
}
