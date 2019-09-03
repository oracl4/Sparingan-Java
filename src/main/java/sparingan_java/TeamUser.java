package sparingan_java;


import java.util.ArrayList;
/**
 * TeamUser.java - kelas untuk menjelaskan informasi user jikan team player
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class TeamUser extends User {
    /**
     * array list untuk menyimpan anggota team
     */
    public ArrayList<User> teamGroup = new ArrayList<>();

    /**
     * constructor dari teamuser
     * @param name
     * @param location
     * @param phoneNumber
     * @param password
     * @param email
     */
    public TeamUser(String name, String location, String phoneNumber, String password, String email){
        super(name, location, phoneNumber, password, email);
    }

    /**
     * melakukan penambahan anggota team baru
     * @param newMember
     */
    public void addMember(User newMember){
        teamGroup.add(newMember);
    }

    /**
     * melakukan penghapusan anggota team
     * @param oldMember
     */
    public void removeMember(User oldMember){
        teamGroup.remove(oldMember);
    }

    /**
     * melakukan toString dan penampilan terhadap atribut kelas TeamUser
     *
     */
    public String toString() {
        String printString = "User Leader \n{" +
                            "name='" + getName() + '\'' +
                            ", location='" + getLocation() + '\'' +
                            ", phoneNumber='" + getPhoneNumber() + '\'' +
                            ", password='" + getPassword() + '\'' +
                            ", email='" + getEmail() + '\'' +
                            ", id=" + getId() +
                            ", isScheduled=" + getIsScheduled() +
                            ", Level=" + getUserLevel() +
                            ", totalMatch =" + getTotalMatch() +
                            '}';
        int i=0;
        for(User userPtr : teamGroup){
                printString = printString +
                        "\nTeam Member (" + (i+1) + ")\n" +
                        "name='" + userPtr.getName() + '\'' +
                        ", location='" + userPtr.getLocation() + '\'' +
                        ", phoneNumber='" + userPtr.getPhoneNumber() + '\'' +
                        ", password='" + userPtr.getPassword() + '\'' +
                        ", email='" + userPtr.getEmail() + '\'' +
                        ", id=" + userPtr.getId() +
                        ", isScheduled=" + userPtr.getIsScheduled() +
                        ", Level=" + userPtr.getUserLevel() +
                        ", totalMatch =" + userPtr.getTotalMatch() +
                        '}';
                i++;
        }
        return printString;
    }
}
