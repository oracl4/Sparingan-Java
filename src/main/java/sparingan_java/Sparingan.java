package sparingan_java;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sparingan {
    public Sparingan(){

    }

    public static void main(String[] args){
        try {
            DatabaseUser.addUser(new User("Mahdi", "Bekasi", "081310275390", "4ltius", "it.mahdi.yusuf@gmail.com"));
            DatabaseUser.addUser(new User("Gilang", "Bogor", "081310275391", "4ltius", "it.gilang.yudharaka@gmail.com"));
            DatabaseUser.addUser(new User("Michael", "Jakarta", "081310275392", "4ltius", "it.michael.wijaya@gmail.com"));
        } catch (UserAlreadyExistsException e) {
            e.getExMessage();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        Sport sportTest = Sport.valueOf("FUTSAL");

        //Implementation.findMatch(sportTest, date1, Location.BANDUNG, 1);
        //Implementation.findMatch(sportTest, date2, Location.BANDUNG, 2);
        //Implementation.findMatch(sportTest, date2, Location.BANDUNG, 3);

        for(Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
            System.out.println(schedulePtr);
        }
        SpringApplication.run(Sparingan.class, args);
    }
}
