
package sparingan_java;
/**
 * UserNotFoundExecption.java - kelas untuk untuk melakukan pengecekan apabila user tidak ditemukan di database
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class UserNotFoundException extends Exception {
    private int user_error;

    /**
     * method untuk melakukan pengecekan dengan menggunakan input dari user
     * @param user_error
     */
    public UserNotFoundException(int user_error){
        super("Schedule ID: ");
        this.user_error = user_error;
    }

    /**
     * menampilkan pesan error ketika user tidak ditemukan
     *
     */
    public String getExMessage()
    {
        return super.getMessage() + user_error + " not found in the Database";
    }

}
