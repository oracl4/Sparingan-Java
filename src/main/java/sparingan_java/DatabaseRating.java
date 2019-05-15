package sparingan_java;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseRating {

    private static HashMap<Integer, ArrayList<Rating>> ratingDatabase = new HashMap<>();

    public static boolean addRating(int id,Rating rating){
       ArrayList<Rating> newRating =  ratingDatabase.get(id);
       newRating.add(rating);
        ratingDatabase.put(id,newRating);
        return true;
    }

    public static boolean deleteRating(int id){
        ratingDatabase.remove(id);
        return true;
    }

    public static ArrayList<Rating> getRating(int id) {
       return ratingDatabase.get(id);
    }

    public HashMap<Integer, ArrayList<Rating>> getRatingDatabase() {
        return ratingDatabase;
    }
}
