package sparingan_java;

import javax.xml.crypto.Data;
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

        int sameLevelScheduleNumber = 0;
        int scheduleNumber = 0;

        //Update User Level based on totalMatch
        try {
            if(DatabaseUser.getUser(userID).getTotalMatch() > 50){
                System.out.println("Elite");
                DatabaseUser.getUser(userID).setUserLevel(Level.ELITE);
            }
            else if(DatabaseUser.getUser(userID).getTotalMatch() > 20){
                System.out.println("Beginner");
                DatabaseUser.getUser(userID).setUserLevel(Level.MODERATE);
            }
        } catch (UserNotFoundException e) {
            e.getExMessage();
        }

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
                    //User with Same Level
                    if(schedulePtr.getUser1().getUserLevel().equals(DatabaseUser.getUser(userID).getUserLevel())) {
                        //System.out.println("Same Level");
                        sameLevelScheduleNumber = schedulePtr.getId();
                    }
                    //User without Same Level
                    else{
                        //System.out.println("!Same Level");
                        scheduleNumber = schedulePtr.getId();
                    }
                } catch (UserNotFoundException e) {
                    e.getExMessage();
                }
            }
        }

        if(sameLevelScheduleNumber != 0 ){
            scheduleNumber = sameLevelScheduleNumber;
        }

        //Check if Schedule Number is Zero
        if(scheduleNumber != 0){
            try {
                //System.out.println("Here");
                DatabaseSchedule.getSchedule(scheduleNumber).setUser2(DatabaseUser.getUser(userID));

                DatabaseSchedule.getSchedule(scheduleNumber).setIsActive(true);
                DatabaseSchedule.getSchedule(scheduleNumber).getUser1().setIsScheduled(true);
                DatabaseSchedule.getSchedule(scheduleNumber).getUser1().setScheduleID(DatabaseSchedule.getSchedule(scheduleNumber).getId());
                DatabaseSchedule.getSchedule(scheduleNumber).getUser1().setEnemyID(userID);

                DatabaseSchedule.getSchedule(scheduleNumber).getUser2().setIsScheduled(true);
                DatabaseSchedule.getSchedule(scheduleNumber).getUser2().setScheduleID(DatabaseSchedule.getSchedule(scheduleNumber).getId());
                DatabaseSchedule.getSchedule(scheduleNumber).getUser2().setEnemyID(DatabaseSchedule.getSchedule(scheduleNumber).getUser1().getId());
                return DatabaseSchedule.getSchedule(scheduleNumber);
            } catch (ScheduleNotFoundException e) {
                e.getExMessage();
            } catch (UserNotFoundException e) {
                e.getExMessage();
            }
        }

        /**
         * jika tidak ada yanng match dengan jadwal maka dikembalikan ke databaseSchedule untuk daftar tunggu
         */
        try {
            DatabaseSchedule.addSchedule(new Schedule(sport, date, location, DatabaseUser.getUser(userID)));
            DatabaseUser.getUser(userID).setScheduleID(DatabaseSchedule.getLastScheduleId());
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
            /*Check if User isn't have schedule or the Schedule is inactive > Failed
            if(DatabaseUser.getUser(idUser).getScheduleID() == 0 || !DatabaseSchedule.getSchedule(idSchedule).getIsActive()) {
                System.out.println("System Failed!");
                //return false;
            }*/

            if(DatabaseSchedule.getSchedule(idSchedule).getUser1() != null) {
                if(DatabaseSchedule.getSchedule(idSchedule).getUser1().getId() == idUser){
                    //System.out.println("Removed User1");
                    DatabaseSchedule.getSchedule(idSchedule).getUser1().setIsScheduled(false);
                    DatabaseSchedule.getSchedule(idSchedule).getUser1().setScheduleID(0);
                    DatabaseSchedule.getSchedule(idSchedule).setUser1(null);
                    //Increment Total Match After Finishing Match
                    DatabaseUser.getUser(idUser).setTotalMatch((DatabaseUser.getUser(idUser).getTotalMatch())+1);
                }
            }

            if(DatabaseSchedule.getSchedule(idSchedule).getUser2() != null) {
                if (DatabaseSchedule.getSchedule(idSchedule).getUser2().getId() == idUser) {
                    System.out.println("Removed User2");
                    DatabaseSchedule.getSchedule(idSchedule).getUser2().setIsScheduled(false);
                    DatabaseSchedule.getSchedule(idSchedule).getUser2().setScheduleID(0);
                    DatabaseSchedule.getSchedule(idSchedule).setUser2(null);
                    //Increment Total Match After Finishing Match
                    DatabaseUser.getUser(idUser).setTotalMatch((DatabaseUser.getUser(idUser).getTotalMatch())+1);
                }
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