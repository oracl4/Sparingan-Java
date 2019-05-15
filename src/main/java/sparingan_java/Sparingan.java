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
        Location location1 = new Location("Jakarta", "Liverpul", Sport.FUTSAL);
        User user1 = new User("Mahdi", "Bekasi", "081310275390", "4ltius", "it.mahdi.yusuf@gmail.com");
        User user2 = new User("Gilang", "Bogor", "081310275391", "4ltius", "it.gilang.yudharaka@gmail.com");
        User user3 = new User("Michael", "Jakarta", "081310275392", "4ltius", "it.michael.wijaya@gmail.com");


        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));

        Implementation.findMatch(Sport.FUTSAL, date1, location1, user1);
        Implementation.findMatch(Sport.FUTSAL, date2, location1, user2);
        Implementation.findMatch(Sport.FUTSAL, date2, location1, user3);

        for(Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
            System.out.println(schedulePtr);
        }
        SpringApplication.run(Sparingan.class, args);
    }
}
