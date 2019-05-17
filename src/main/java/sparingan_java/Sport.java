
package sparingan_java;

/**
 * Sport.java - kelas untuk enum pilhan jenis olahraga yang dimainkan
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public enum Sport {
    BASKETBALL("Basketball"),
    FUTSAL("Futsal"),
    BADMINTON("Badminton"),
    BASEBALL("Baseball"),
    SOFTBALL("Softball");

    private String sport;
    Sport(String sport){
        this.sport = sport;
    }
    public String toString(){
        return sport;
    }
}
