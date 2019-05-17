
package sparingan_java;

/**
 * ScheduleNotFoundException.java - kelas untuk pengecekan jadwal apabilatidal tersedia di database
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class ScheduleNotFoundException extends Exception {
    private int schedule_error;

    /**
     * mengambil nilai schedule error
     * @param schedule_error
     */
    public ScheduleNotFoundException(int schedule_error){
        super("Schedule ID: ");
        this.schedule_error = schedule_error;
    }

    /** menampilkan pesan jadwal tidak tersedia
     *
     * @return
     */
    public String getExMessage(){
        return super.getMessage() + schedule_error + " not found in the Database";
    }

}
