package sparingan_java;


import java.util.ArrayList;
/**
 * ......java - kelas untuk
 * @author  Gilang Yudharaka,Luthfi Faisal, Mahdi Yusuf,Michael Wijaya, Naufal Ikhsan
 * @version 2.0
 * @since 2019-05-17
 */
public class TeamUser extends User {
    public ArrayList<User> teamGroup = new ArrayList<>();

    public TeamUser(String name, String location, String phoneNumber, String password, String email){
        super(name, location, phoneNumber, password, email);
    }

    public void addMember(User newMember){
        teamGroup.add(newMember);
    }

    public void removeMember(User oldMember){
        teamGroup.remove(oldMember);
    }

    public String toString() {
        String printString = "User Leader \n{" +
                            "name='" + getName() + '\'' +
                            ", location='" + getLocation() + '\'' +
                            ", phoneNumber='" + getPhoneNumber() + '\'' +
                            ", password='" + getPassword() + '\'' +
                            ", email='" + getEmail() + '\'' +
                            ", id=" + getId() +
                            ", isScheduled=" + getIsScheduled() +
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
                        '}';
                i++;
        }
        return printString;
    }
}
