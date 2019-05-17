package sparingan_java;
import java.util.ArrayList;
/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class DatabaseSchedule {
    private static ArrayList<Schedule> SCHEDULE_DATABASE = new ArrayList<>();
    private static int LAST_SCHEDULE_ID = 0;

    public static ArrayList<Schedule> getScheduleDatabase() {
        return SCHEDULE_DATABASE;
    }

    public static int getLastScheduleId() {
        return LAST_SCHEDULE_ID;
    }

    public static boolean addSchedule(Schedule schedule) {
        SCHEDULE_DATABASE.add(schedule);
        LAST_SCHEDULE_ID = schedule.getId();
        return true;
    }
    public static Schedule getSchedule (int id) throws ScheduleNotFoundException{
        for(Schedule schedule : SCHEDULE_DATABASE){
            if(schedule.getId() == id){
                return schedule;
            }
        }
        throw new ScheduleNotFoundException(id);
    }
    public static boolean removeSchedule (int id) throws ScheduleNotFoundException{
        for (Schedule schedule : SCHEDULE_DATABASE){
            if(schedule.getId() == id){
                SCHEDULE_DATABASE.remove(schedule);
                return true;
            }
        }
        throw new ScheduleNotFoundException(id);
    }
}
