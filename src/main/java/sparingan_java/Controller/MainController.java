package sparingan_java.Controller;

import org.springframework.web.bind.annotation.*;
import sparingan_java.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MainController {
    //Find Match
    @RequestMapping(value = "/findmatch", method = RequestMethod.POST)
    public Schedule findMatch (@RequestParam(value = "sport") String sport,
                                @RequestParam(value = "year") int year,
                                @RequestParam(value = "month") int month,
                                @RequestParam(value = "date") int date,
                                @RequestParam(value = "location") String location,
                                @RequestParam(value = "userid") int userid
    ) {
        Calendar tempDate = new GregorianCalendar(year, month - 1, date);
        Location tempLocation = Location.valueOf(location);
        Sport tempSport = Sport.valueOf(sport);
        return Implementation.findMatch(tempSport, tempDate, tempLocation, userid);
    }

    //Finish Schedule
    @RequestMapping(value = "/finishmatch", method = RequestMethod.POST)
    public Boolean findMatch (@RequestParam(value = "scheduleid") int idSchedule,
                                @RequestParam(value = "userid") int idUser
    ) {
        boolean status = Implementation.finishSchedule(idSchedule, idUser);
        return status;
    }
}