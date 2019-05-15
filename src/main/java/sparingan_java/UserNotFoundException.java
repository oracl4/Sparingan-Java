package sparingan_java;

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
