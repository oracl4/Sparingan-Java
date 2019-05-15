package sparingan_java.Controller;

import org.springframework.web.bind.annotation.*;
import sparingan_java.*;

import java.util.ArrayList;

@RestController
public class ScheduleController {

    //Schedule List
    @RequestMapping(value = "/schedulelist", method = RequestMethod.GET)
    public ArrayList<Schedule> scheduleList() {
        return DatabaseSchedule.getScheduleDatabase();
    }

    //Schedule by ID
    @RequestMapping(value = "/schedule/{scheduleID}", method = RequestMethod.GET)
    public Schedule getScheduleFromID(@PathVariable int scheduleID) {
        Schedule schedule = null;
        try {
            schedule = DatabaseSchedule.getSchedule(scheduleID);
        } catch (ScheduleNotFoundException e) {
            e.getExMessage();
        }
        return schedule;
    }
}
