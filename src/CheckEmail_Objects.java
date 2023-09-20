import java.util.ArrayList;

public class CheckEmail_Objects {
    public static boolean checkEmailObj(Email mail, ArrayList<Email> emailList) {
        boolean state = true;
        for(Email email:emailList){
            if(mail.emailAddress.equals(email.emailAddress) && mail.date.equals(email.date) && mail.subject.equals(email.subject) && mail.content.equals(email.content)){
                state = false;
            }
        }return state;
    }
}
