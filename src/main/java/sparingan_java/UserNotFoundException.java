
package sparingan_java;
/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class UserNotFoundException extends Exception {
    private int user_error;

    public UserNotFoundException(int user_error){
        super("Schedule ID: ");
        this.user_error = user_error;
    }

    public String getExMessage()
    {
        return super.getMessage() + user_error + " not found in the Database";
    }

}
