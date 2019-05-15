package sparingan_java;
public class ScheduleNotFoundException extends Exception {
    private int schedule_error;

    public ScheduleNotFoundException(int schedule_error){
        super("Schedule ID: ");
        this.schedule_error = schedule_error;
    }

    public String getExMessage(){
        return super.getMessage() + schedule_error + " not found in the Database";
    }

}
