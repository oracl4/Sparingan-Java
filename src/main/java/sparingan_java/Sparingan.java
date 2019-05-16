package sparingan_java;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

@SpringBootApplication
public class Sparingan {
    public Sparingan(){

    }

    public static void main(String[] args){
        try {
            DatabaseUser.addUser(new SoloUser("Mahdi", "Bekasi", "081310275390", "4ltius", "it.mahdi.yusuf@gmail.com"));
            System.out.println(DatabaseUser.getUser(DatabaseUser.getLastUserId()));
            DatabaseUser.addUser(new SoloUser("Gilang", "Bogor", "081310275391", "4ltius", "it.gilang.yudharaka@gmail.com"));
            System.out.println(DatabaseUser.getUser(DatabaseUser.getLastUserId()));
            DatabaseUser.addUser(new TeamUser("Michael", "Jakarta", "081310275392", "4ltius", "it.michael.wijaya@gmail.com"));
            System.out.println(DatabaseUser.getUser(DatabaseUser.getLastUserId()));
            ((TeamUser)DatabaseUser.getUser(3)).addMember(DatabaseUser.getUser(2));
            ((TeamUser)DatabaseUser.getUser(3)).addMember(DatabaseUser.getUser(1));
            System.out.println(DatabaseUser.getUser(3));
        } catch (UserAlreadyExistsException e) {
            e.getExMessage();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        Sport sportTest = Sport.valueOf("FUTSAL");

        for(Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
            System.out.println(schedulePtr);
        }
        SpringApplication.run(Sparingan.class, args);
    }
}
