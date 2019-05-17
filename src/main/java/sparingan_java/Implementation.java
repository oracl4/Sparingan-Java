package sparingan_java;

import java.util.Calendar;
import java.util.Date;

/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
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
                //schedulePtr.getUser1().setUserSchedules(schedulePtr);
                schedulePtr.getUser2().setIsScheduled(true);
                //schedulePtr.getUser2().setUserSchedules(schedulePtr);
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
