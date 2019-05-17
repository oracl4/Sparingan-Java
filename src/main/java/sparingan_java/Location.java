package sparingan_java;

/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public enum Location {
    JAKARTA("Jakarta"),
    DEPOK("Depok"),
    BOGOR("Bogor"),
    BANDUNG("Bandung");

    private String location;

    Location(String location){
        this.location = location;
    }
    public String toString(){
        return location;
    }
}
