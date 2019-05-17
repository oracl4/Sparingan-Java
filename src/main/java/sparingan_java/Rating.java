package sparingan_java;
/**
 * Rating.java - kelas menjelaskan informasi mengenai rating dari user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class Rating {
    private User user;
    private String feedback;
    private double rating;
    /**constructur untuk kelas Rating*
    * @param user
    */
    public Rating(User user) {
        this.user = user;
    }

    /**
     * method untuk melakukan pengambilan feedback
     * @return feeback
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * method untuk melakukan set feedback dari user
     * @param feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * method untuk melakukan pengambilan data user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * method untuk melakukan set dari user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * method untuk melakukan pengambilan nilai rating
     * @return rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * method untuk melakukan set nilai rating
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * method untuk melakukan toString terhadap atribut kelas Rating
     * @return
     */
    public String toString() {
        return "Rating{" +
                "user=" + user +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}
