
package sparingan_java;

import java.util.ArrayList;

/**
 * User.java - kelas untuk menjelaskan atribut dan method dari pengguna yang menggunakan sparingan web
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public abstract class User {

    /**
     * atribut dari user pengguna sparingan web
     */
    private String name, location, phoneNumber, password,email;
    private int id;
    private Rating rating;
    private double rating;
    //private Schedule userSchedules;
    private UserType userType;
    private boolean isScheduled;

    /**
     * method untuk melakukan pengambilan jadwal user
     * @return isScheduled
     */
    public boolean getIsScheduled() {
        return isScheduled;
    }

    /**
     * method untuk melakukan set jadwal user
     * @param status
     */
    public void setIsScheduled(boolean status) {
        this.isScheduled = status;
    }

    /**
     * constructor untuk abstract class User
     * @param name
     * @param location
     * @param phoneNumber
     * @param password
     * @param email
     */
    public User(String name, String location, String phoneNumber, String password, String email) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.isScheduled=false;
        this.id = DatabaseUser.getLastUserId() + 1;
        rating = 0;
    }

    /**
     * method untuk mengambil nama dari user
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method untuk melakukan set nama dari user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method untuk mengambil rating berdasarkan id dari uer yang berasal dari database rating
     * @return rating
     */
    public double getRating(){
        if(DatabaseRating.getRating(id) != null){
            for (Rating rate : DatabaseRating.getRating(id)){
                rating = rating + rate.getRating();
            }
            rating = rating / DatabaseRating.getRating(id).size();
        }
        return rating;
    }

    /**
     * method untuk mengambil lokasi dari user
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * method untuk melakukan set lokasi dari user
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * method untuk mengambil no hp dari user
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * method untuk melakukan set no hp user
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * method untuk melakukan pengambilan password dari user
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * method untuk melakukan set password dari user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * method untuk melakukan pengambilan email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * method untuk melakukan set email user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * method untuk melakukan pengambilan id dari user
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * method untuk melakukan set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /*public Schedule getUserSchedules() {
        return userSchedules;
    }

    public void setUserSchedules(Schedule userSchedules) {
        this.userSchedules = userSchedules;
    }
     */

    /**
     * method abstact untuk melakukan toString terhadap atribut user
     */
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
