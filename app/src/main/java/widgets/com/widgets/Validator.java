package widgets.com.widgets;

/**
 * Created by Neeraj on 3/19/2016.
 */
public class Validator {
    static boolean validEmail(String email){
        if(email.contains("@") && email.endsWith(".com")){
            return true;
        }
        return false;
    }

    static boolean validPassword(String password){
        if(password.length() > 6){
            return true;
        }
        return false;
    }

    static String validateAge(int age){
        if(age <= 50){
            return "valid";
        }
        return "Age is Invalid!";
    }
}
