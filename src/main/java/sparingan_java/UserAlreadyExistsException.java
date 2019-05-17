
package sparingan_java;

/**
 * UserAlreadyExistsException.java - kelas untuk melakukan pengecekan apabila user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class UserAlreadyExistsException extends Exception
{
    private User user_error;

    public UserAlreadyExistsException(User user_input)
    {
        super("Schedule Email : ");
        user_error = user_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + user_error.getEmail()
                + ", or phoneNumber : " + user_error.getPhoneNumber() + " already exists.";
    }
}