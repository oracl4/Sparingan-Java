
package sparingan_java;
/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
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
                ", isScheduled=" + getIsScheduled() +
                '}';
    }
}
