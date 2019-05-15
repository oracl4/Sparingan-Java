package sparingan_java;

import java.util.Calendar;
import java.util.Date;

public class Implementation {

    public Implementation(){
    }

    public static Schedule findMatch(Sport sport, Calendar date, Location location, int userID) {
        //Find in Database
        for (Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
            if (schedulePtr.getDate().equals(date) &&
                    schedulePtr.getLocation().equals(location) &&
                    schedulePtr.getSport().equals(sport) &&
                    !schedulePtr.getIsActive()
            ) {
                try {
                    schedulePtr.setUser2(DatabaseUser.getUser(userID));
                } catch (UserNotFoundException e) {
                    e.getExMessage();
                }
                schedulePtr.setIsActive(true);
                schedulePtr.getUser1().setIsScheduled(true);
                schedulePtr.getUser2().setIsScheduled(true);
                return schedulePtr;
            }
        }
        try {
            DatabaseSchedule.addSchedule(new Schedule(sport, date, location, DatabaseUser.getUser(userID)));
            return DatabaseSchedule.getSchedule(DatabaseSchedule.getLastScheduleId());
        } catch (UserNotFoundException e) {
            e.getExMessage();
        } catch (ScheduleNotFoundException e) {
            e.getExMessage();
        }
        return null;
    }
}
