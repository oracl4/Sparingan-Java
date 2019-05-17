package sparingan_java;

import java.util.Calendar;
import java.util.Date;

/**
 * Implementation.java - kelas untuk fungsi pembanding dan pencocok match antara User
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class Implementation {

    public Implementation(){
    }

    /**
     * method untuk melakukan pembandingan dan pencocokan antara user dengan menggunakan informasi dari schedule setiap user
     * @param sport
     * @param date
     * @param location
     * @param userID
     * @return null
     */
    public static Schedule findMatch(Sport sport, Calendar date, Location location, int userID) {
        /**
         * mengambil jadwal user
         */
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
        /**
         * jika tidak ada yanng match dengan jadwal maka dikembalikan ke databaseSchedule untuk daftar tunggu
         */
        try {
            DatabaseSchedule.addSchedule(new Schedule(sport, date, location, DatabaseUser.getUser(userID)));
            return DatabaseSchedule.getSchedule(DatabaseSchedule.getLastScheduleId());
        } catch (UserNotFoundException e) {
            e.getExMessage();
        } catch (ScheduleNotFoundException e) {
            e.getExMessage();
        }
        /**
         * dilakukan pengembalian nilai null agar tidak infinite loop
         */
        return null;
    }
}
