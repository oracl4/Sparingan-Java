package sparingan_java.Controller;

import org.springframework.web.bind.annotation.*;
import sparingan_java.*;
import java.util.regex.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public User newUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "location") String location,
                        @RequestParam(value = "phoneNumber") String phoneNumber,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "usertype") String usertype
    )
    {
        if(!checkEmail(email)) {
            return null;
        }

        UserType tempUserType = UserType.valueOf(usertype);

        //Create Solo
        if(tempUserType.equals(UserType.SOLO)){
            try {
                DatabaseUser.addUser(new SoloUser(name, location, phoneNumber, password, email));
                return DatabaseUser.getUser(DatabaseUser.getLastUserId());
            } catch (UserAlreadyExistsException e) {
                e.getExMessage();
            } catch (UserNotFoundException e) {
                e.getExMessage();
            }
        }
        //Create Team
        else if(tempUserType.equals(UserType.TEAM)){
            try {
                DatabaseUser.addUser(new TeamUser(name, location, phoneNumber, password, email));
                return DatabaseUser.getUser(DatabaseUser.getLastUserId());
            } catch (UserAlreadyExistsException e) {
                e.getExMessage();
            } catch (UserNotFoundException e) {
                e.getExMessage();
            }
        }
        return null;
    }

    @RequestMapping(value="/loginuser", method=RequestMethod.POST)
    public User loginUser (@RequestParam(value="email") String email,
                            @RequestParam(value="password") String password
    )
    {
        User customerReply = DatabaseUser.getUserLogin(email,password);
        return customerReply;
    }

    @RequestMapping("/getuser/{id}")
    public User getUser(@PathVariable int id) {
        User user = null;
        try {
            user = DatabaseUser.getUser(id);
        } catch (UserNotFoundException e) {
            e.getExMessage();
        }
        return user;
    }

    @RequestMapping(value="/addmember", method=RequestMethod.POST)
    public User loginUser (@RequestParam(value="teamid") int teamid,
                           @RequestParam(value="newmemberid") int newmemberid
    )
    {
        try {
            User tempUser = DatabaseUser.getUser(teamid);
            if(tempUser instanceof TeamUser && newmemberid != teamid){
                ((TeamUser)tempUser).addMember(DatabaseUser.getUser(newmemberid));
                return tempUser;
            }
        } catch (UserNotFoundException e) {
            e.getExMessage();
        }
        return null;
    }

    public boolean checkEmail(String email){
        String pattern =  ".*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }
}
