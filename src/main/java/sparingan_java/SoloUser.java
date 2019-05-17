
package sparingan_java;
/**
 * SoloUser.java - kelas untuk meninfomarsikan atribut dari user yang solo player
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class SoloUser extends User {

    /**
     * constructor dari kelas SoloUser
     * @param name
     * @param location
     * @param phoneNumber
     * @param password
     * @param email
     */
    public SoloUser(String name, String location, String phoneNumber, String password, String email){
        super(name, location, phoneNumber, password, email);
    }

    /**
     * melakukan toString atribut SoloUser
     *
     */
    public String toString() {
        return "User \n{" +
                "name='" + getName() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", rating='" + getRating() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", id=" + getId() +
                ", isScheduled=" + getIsScheduled() +
                '}';
    }
}
