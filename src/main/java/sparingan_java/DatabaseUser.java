package sparingan_java;
import java.util.ArrayList;
/**
 * DatabaseUser.java - kelas untuk menyimpan informasi user kedalam array list database
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class DatabaseUser {
    private static ArrayList<User> USER_DATABASE = new ArrayList<>();
    private static int LAST_USER_ID = 0;

    /**
     * arraylist dari kumpulan user;
      * @return USER_DATABASE
     */
    public static ArrayList<User> getUserDatabase() {
        return USER_DATABASE;
    }

    /**
     * mengambil ID user terakhir
     * @return LAST_USER_ID
     */
    public static int getLastUserId() {
        return LAST_USER_ID;
    }

    /**
     *melakukan penambahan user baru
     * @param user
     * @return true
     * @throws UserAlreadyExistsException
     */
    public static boolean addUser(User user) throws UserAlreadyExistsException {
        for (User userTemp : USER_DATABASE )
        {
            if(((user.getPhoneNumber().equals(userTemp.getPhoneNumber()))
                    || (user.getEmail().equals(userTemp.getEmail()))))
            {
                throw new UserAlreadyExistsException(user);
            }
        }
        USER_DATABASE.add(user);
        LAST_USER_ID = user.getId();
        return true;
    }

    /**
     * mengambil user dari database berdasarkan id
     * @param id
     * @return user
     * @throws UserNotFoundException
     */
    public static User getUser(int id) throws UserNotFoundException{
        for(User user : USER_DATABASE){
            if(user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException(id);
    }

    /**
     * melakukan penghapusan user berdasarkan id
     * @param id
     * @return true
     * @throws UserNotFoundException
     */
    public static boolean removeUser (int id) throws UserNotFoundException{
        for (User user : USER_DATABASE){
            if(user.getId() == id){
                USER_DATABASE.remove(user);
                return true;
            }
        }
        throw new UserNotFoundException(id);
    }

    /**
     * melakukan pemcarian user berdasarakan data login pada database user
     * @param email
     * @param password
     * @return null
     */
    public static User getUserLogin(String email, String password){
        for (User UserPtr : USER_DATABASE){
            if (UserPtr.getEmail().equals(email) && UserPtr.getPassword().equals(password))
            {
                return UserPtr;
            }
        }
        return null;
    }
}
