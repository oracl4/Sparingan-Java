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
                schedulePtr.getUser1().setScheduleID(schedulePtr.getId());
                schedulePtr.getUser2().setIsScheduled(true);
                schedulePtr.getUser2().setScheduleID(schedulePtr.getId());
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

    public static boolean finishSchedule(int idSchedule, int idUser){
        try {
            //Check if User isn't have schedule or the Schedule is inactive > Failed
            if(!DatabaseUser.getUser(idUser).getIsScheduled() ||
                    !DatabaseSchedule.getSchedule(idSchedule).getIsActive()){
                System.out.println("System Failed!");
                return false;
            }
            //User1 Finish
            if(DatabaseSchedule.getSchedule(idSchedule).getUser1().getId() == idUser){
                System.out.println("Removed User1");
                DatabaseSchedule.getSchedule(idSchedule).getUser1().setIsScheduled(false);
                DatabaseSchedule.getSchedule(idSchedule).getUser1().setScheduleID(0);
                DatabaseSchedule.getSchedule(idSchedule).setUser1(null);
            }
            //User 2 Finish
            else if(DatabaseSchedule.getSchedule(idSchedule).getUser2().getId() == idUser){
                System.out.println("Removed User2");
                DatabaseSchedule.getSchedule(idSchedule).getUser2().setIsScheduled(false);
                DatabaseSchedule.getSchedule(idSchedule).getUser2().setScheduleID(0);
                DatabaseSchedule.getSchedule(idSchedule).setUser2(null);
            }
            //Remove the Schedule if User1 dan User2 NULL
            if(DatabaseSchedule.getSchedule(idSchedule).getUser1() == null &&
                    DatabaseSchedule.getSchedule(idSchedule).getUser2() == null){
                System.out.println("Removed Schedule");
                DatabaseSchedule.removeSchedule(idSchedule);
            }
        } catch (ScheduleNotFoundException e) {
            e.getExMessage();
        } catch (UserNotFoundException e) {
            e.getExMessage();
        }
        return false;
    }
}