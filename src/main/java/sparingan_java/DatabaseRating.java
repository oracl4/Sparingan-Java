package sparingan_java;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
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
