package sparingan_java;
import java.util.ArrayList;

public class DatabaseUser {
    private static ArrayList<User> USER_DATABASE = new ArrayList<>();
    private static int LAST_USER_ID = 1;

    public static ArrayList<User> getUserDatabase() {
        return USER_DATABASE;
    }

    public static int getLastUserId() {
        return LAST_USER_ID;
    }

    public static boolean addUser(User user) {
        USER_DATABASE.add(user);
        LAST_USER_ID = user.getId();
        return true;
    }
    public static User getUser(int id) throws UserNotFoundException{
        for(User user : USER_DATABASE){
            if(user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException(id);
    }
    public static boolean removeUser (int id) throws UserNotFoundException{
        for (User user : USER_DATABASE){
            if(user.getId() == id){
                USER_DATABASE.remove(user);
                return true;
            }
        }
        throw new UserNotFoundException(id);
    }
}
