package sparingan_java;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * DatabaseRating.java - kelas untuk untuk menyompan nilai rating dari setiap user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class DatabaseRating {
    private static HashMap<Integer, ArrayList<Rating>> ratingDatabase = new HashMap<>();

    public static void createUserRatingDatabase(int id){

        ArrayList<Rating> empty = new ArrayList<>();
        ratingDatabase.put(id, empty );

    }

    /**
     * menambah rating dari user
     * @param id
     * @param rating
     * @return true
     */
    public static boolean addRating(int id,Rating rating){
        ratingDatabase.get(id).add(rating);
        //ratingDatabase.put(id,getRating(id));
        return true;
    }

    /**
     * menghapus rating dari user
     * @param id
     * @return true
     */
    public static boolean deleteRating(int id){
        ratingDatabase.remove(id);
        return true;
    }

    /**
     * mengambil nilai rating berdasarkan id
     * @param id
     * @return ratingDatabase
     */
    public static ArrayList<Rating> getRating(int id) {
        return ratingDatabase.get(id);
    }

    public HashMap<Integer, ArrayList<Rating>> getRatingDatabase() {
        return ratingDatabase;
    }
}
