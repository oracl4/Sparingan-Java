package sparingan_java.Controller;
import org.springframework.web.bind.annotation.*;
import sparingan_java.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RatingController {
    //List all rating History
    @RequestMapping(value = "/getratinghistory/{id}", method = RequestMethod.GET)
    public ArrayList<Rating> getRatingHistory(@PathVariable int id) {
        return DatabaseRating.getRating(id);
    }

    //Give Rating to User
    @RequestMapping(value = "/giverating", method = RequestMethod.POST)
    public boolean giveRating(@RequestParam(value = "rating") double rating,
                              @RequestParam(value = "feedback") String feedback,
                              @RequestParam(value = "user1id") int user1id)
    {
        try {
            //If EnemyID is 0 / Havent give rating
            if (DatabaseUser.getUser(user1id).getEnemyID() != 0) {
                //Insert the rating giver's ID (user 1)
                Rating rate = new Rating(DatabaseUser.getUser(user1id), rating, feedback);
                //Insert rating to user 2 's rating database
                DatabaseRating.addRating(DatabaseUser.getUser(user1id).getEnemyID(), rate);
                DatabaseUser.getUser(user1id).setEnemyID(0);
                return true;
            }
        }
        catch (UserNotFoundException e) {
            e.getExMessage();
        }
        return false;
    }
}

