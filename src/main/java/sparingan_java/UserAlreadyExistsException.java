
package sparingan_java;

/**
 * UserAlreadyExistsException.java - kelas untuk melakukan pengecekan apabila user sudah tersedia pada database ketika sedang mendaftar
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class UserAlreadyExistsException extends Exception
{
    private User user_error;

    /**
     * method untuk melakukan pengecekan dengan menggunakan user_input
     * @param user_input
     */
    public UserAlreadyExistsException(User user_input)
    {
        super("Schedule Email : ");
        user_error = user_input;
    }

    /**
     * menampilkan pesan error saat user sudah tersedia di database
     * @return
     */
    public String getExMessage()
    {
        return super.getMessage() + user_error.getEmail()
                + ", or phoneNumber : " + user_error.getPhoneNumber() + " already exists.";
    }
}