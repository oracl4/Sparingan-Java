
package sparingan_java;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Schedule.java - kelas untuk berisi informasi atribut dan method dari schedule atau jadwal user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class Schedule {
    private int id;

    private Sport sport;
    private Location location;
    private Calendar date;
    private User user1;
    private User user2;
    private boolean isActive;

    /**
     * constructur untuk melakukan pengambilan jadwal user yang nantinya akan dibandingkan dengan user lain
     * @param sport
     * @param date
     * @param location
     * @param user1
     */
    public Schedule(Sport sport, Calendar date, Location location, User user1) {
        this.sport = sport;
        this.location = location;
        this.date = date;
        this.user1 = user1;
        id = DatabaseSchedule.getLastScheduleId() + 1;
        this.isActive = false;
    }

    /**
     * method untuk mengambil id user
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method untuk melakukan set id user
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method untuk mengambil infomasi dari kelas sport
     * @return sport
     */
    public Sport getSport() {
        return sport;
    }

    /**
     *
     * method untuk melakukan set nilai sport kedalam kelas Sport
     * @param sport
     */
    public void setSport(Sport sport) {
        this.sport = sport;
    }
    /**
     * method untuk melakukan pengambilan nilai lokasi dari kelas Location
    * return location
    */
    public Location getLocation() {
        return location;
    }

    /**
     * method untuk melakukan set nilai lokasi ke kelas Location
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * method untuk melakukan pengambilan date dari class Calendar
     * @return date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * method untuk melakukan set nilai date ke dalam kelas Calendar
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * mengambil user 1
     * @return user1
     */
    public User getUser1() {
        return user1;
    }

    /**
     * melakukan set user 1
     * @param user1
     */
    public void setUser1(User user1) {
        this.user1 = user1;
    }

    /**
     * melakukan pengambilan user2
     * @return user2
     */
    public User getUser2() {
        return user2;
    }

    /**
     * melakukan set user2
     * @param user2
     */
    public void setUser2(User user2) {
        this.user2 = user2;
    }

    /**
     * melakukan pengambilan status dari user
     * @return isActive
     */
    public boolean getIsActive(){
        return isActive;
    }

    /**
     * melakukan set status dari user
     * @param status
     */
    public void setIsActive(boolean status){
        this.isActive = status;
    }

    /**
     * method untuk melakukan to string terhadap atribut kelas Schedule
     * dan juga melakukan penampilan user 2 yang menjadi lawan main
     */
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
