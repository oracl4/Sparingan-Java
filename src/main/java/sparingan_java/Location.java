package sparingan_java;

/**
 * Location.java - kelas enum untuk pilihan kota lokasi user
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 * @return location
 */
public enum Location {
    JAKARTA("Jakarta"),
    BEKASI("Bekasi"),
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
