package sparingan_java;
import java.util.Date;

public class Implementation {

    public Implementation(){
    }

    public static boolean findMatch(Sport sport, Date date, Location location, User user) {
        for (Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
            if (schedulePtr.getDate().equals(date) &&
                    schedulePtr.getLocation().equals(location) &&
                    schedulePtr.getSport().equals(sport) &&
                    !schedulePtr.getIsActive()
            ) {
                schedulePtr.setUser2(user);
                schedulePtr.setIsActive(true);
                schedulePtr.getUser1().setIsScheduled(true);
                schedulePtr.getUser2().setIsScheduled(true);
                return true;
            }
        }
        DatabaseSchedule.addSchedule(new Schedule(sport, date, location, user));
        return false;
    }
}
