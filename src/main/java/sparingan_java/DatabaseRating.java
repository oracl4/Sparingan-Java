import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseRating {

    private static HashMap<Integer, ArrayList<Rating>> ratingDatabase = new HashMap<>();

    public static boolean addRating(int id,Rating rating){
        ratingDatabase.get(id).add(rating);
        //ratingDatabase.put(id,getRating(id));
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
