package sparingan_java.controller;

import org.springframework.web.bind.annotation.*;
import sparingan_java.*;

import java.util.ArrayList;

@RestController
public class RatingController {
    //List all rating History
    @RequestMapping(value ="/getratinghistory/{id}" , method = RequestMethod.GET)
    public ArrayList<Rating> getRatingHistory(@PathVariable int id) {
        return DatabaseRating.getRating(id);
    }
    
    //Give Rating to User
    @RequestMapping(value = "/giverating", method = RequestMethod.POST)
    public void giveRating(@RequestParam(value = "rating") double rating,
                           @RequestParam(value = "feedback") String feedback,
                           @RequestParam (value = "user2id") int user2id){
        try {
            Rating rate = new Rating(DatabaseUser.getUser(user2id));
            rate.setRating(rating);
            rate.setFeedback(feedback);
            DatabaseRating.addRating(user2id, rate);
        } catch (UserNotFoundException e){
            e.getExMessage();
        }

    }
}
