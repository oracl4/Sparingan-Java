package sparingan_java;
/**
 * Rating.java - kelas menjelaskan informasi mengenai rating dari user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class Rating {
    private User fromUser;
    private String feedback;
    private double rating;

    public Rating(User fromUser, double rating, String feedback) {
        this.fromUser = fromUser;
        this.rating = rating;
        this.feedback = feedback;
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
        return fromUser;
    }

    public void setUser(User fromUser) {
        this.fromUser = fromUser;
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
                "fromUser=" + fromUser +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}