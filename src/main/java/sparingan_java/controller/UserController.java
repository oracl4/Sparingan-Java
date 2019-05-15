package sparingan_java.controller;
import org.springframework.web.bind.annotation.*;
import sparingan_java.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;
import javax.xml.crypto.Data;

@RestController
public class UserController {
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public User newUser(@RequestParam(value = "name") String name,
                        @RequestParam(value = "location") String location,
                        @RequestParam(value = "phoneNumber") String phoneNumber,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "email") String email
    )
    {
        if(!checkEmail(email)){
            return null;
        }
        User user = new User(name, location, phoneNumber, password, email);
        try {
            DatabaseUser.addUser(user);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        };
        return user;

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
