
package sparingan_java;

/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public enum UserType {
    SOLO("Team"),
    TEAM("Solo");

    private String userType;

    UserType(String userType){
        this.userType = userType;
    }
    public String toString(){
        return userType;
    }
}

