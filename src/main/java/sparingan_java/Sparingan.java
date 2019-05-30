
package sparingan_java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;

/**
 * Sparingan.java - kelas utama untuk web sparingan
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
@SpringBootApplication
public class Sparingan {
    public Sparingan(){
    }

    /**
     * method untuk
     * melakukan pengambilan user, serta match dengan user lainnya
     */
    public static void main(String[] args){
//        /**
//         * melakukan pengambilan user dari DatabaseUser
//         */
//        try {
//            DatabaseUser.addUser(new SoloUser("Mahdi", "Bekasi", "081310275390", "4ltius", "spar.mahdi@gmail.com"));
//            DatabaseUser.addUser(new SoloUser("Gilang", "Bogor", "081310275391", "4ltius", "spar.gilang@gmail.com"));
//            DatabaseUser.addUser(new TeamUser("Michael", "Jakarta", "081310275392", "4ltius", "spar.michael@gmail.com"));
////            ((TeamUser)DatabaseUser.getUser(3)).addMember(DatabaseUser.getUser(2));
////            ((TeamUser)DatabaseUser.getUser(3)).addMember(DatabaseUser.getUser(1));
////            System.out.println(DatabaseUser.getUser(3));
//        }
//        /**
//         * melakukan pemeriksaan error
//         */
//        catch (UserAlreadyExistsException e) {
//            e.getExMessage();
//        }
//        /**
//         * melakukan pengambilan nilai tanggal dan disimpan dalam Calendar dengan format gregorian
//         */
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
//        Calendar date1 = new GregorianCalendar(2019, 7, 12);
//        //Calendar date2 = new GregorianCalendar();
//        //System.out.println(sdf.format(date1));
//        //System.out.println(sdf.format(date2));
//
//        Sport sportTest = Sport.valueOf("FUTSAL");
//
//        /**
//         * melakukan findmatch antara 2 user berdasarkan informasi yang sudah diambil
//         */
//        //Implementation.findMatch(Sport.FUTSAL, date1, Location.BANDUNG, 1);
//        //Implementation.findMatch(Sport.FUTSAL, date1, Location.BANDUNG, 2);
//
//        for(Schedule schedulePtr : DatabaseSchedule.getScheduleDatabase()) {
//            System.out.println(schedulePtr);
//        }
//
//        //Implementation.finishSchedule(1, 1);
//        //Implementation.finishSchedule(1, 2);
//
        SpringApplication.run(Sparingan.class, args);
    }
}
