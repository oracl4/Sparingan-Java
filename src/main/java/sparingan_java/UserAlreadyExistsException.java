package sparingan_java;

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