import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Birthday_Wish {

    public static void birthdayWish(ArrayList<Recip_ients> recipients, LocalDate date) throws MessagingException, IOException, ClassNotFoundException {
        //  LocalDate date = Date;
        String dateToday = date.format(DateTimeFormatter.ISO_DATE);
        String[] month_and_Date_Today = dateToday.split("-");
        for(Recip_ients recipient : recipients){
            if(recipient instanceof Office_friend ){
                String[] month_and_date_of_OfficeFriend = ((Office_friend) recipient).birthday.split("/");
                boolean check_month = (month_and_date_of_OfficeFriend[1].equals(month_and_Date_Today[1]));
                boolean check_date = (month_and_date_of_OfficeFriend[2].equals(month_and_Date_Today[2]));
                if(check_month && check_date){
                    Office_friend office_friend = ((Office_friend) recipient);
                    String name = office_friend.name;
                    String emailAddress = office_friend.email;
                    String subject = "";
                    String content = "Wish you a Happy Birthday, Chamil";
                    Email emailObj = new Email(emailAddress, subject,content,date);

                    if(CheckEmail_Objects.checkEmailObj(emailObj, Test2.emailList)){
                        System.out.printf("Sending wishes to %s...\n",name);
                        Email_Sending.sendMail(emailAddress,subject, content);
                        Test2.emailList = Create_ArrayList.createTheArrayList(emailObj, "emails.ser");
                    }
                }
            }
            if(recipient instanceof Personal){
                String[] month_and_date_of_Personal = ((Personal) recipient).birthday.split("/");
                boolean check_month = (month_and_date_of_Personal[1].equals(month_and_Date_Today[1]));
                boolean check_date = (month_and_date_of_Personal[2].equals(month_and_Date_Today[2]));

                if(check_month && check_date){
                    Personal personal = (Personal) recipient;
                    String name = personal.name;
                    String emailAddress = personal.email;
                    String subject = "";
                    String content = "hugs and love on your birthday, Chamil";
                    Email emailObj = new Email(emailAddress, subject,content,date);
                    if(CheckEmail_Objects.checkEmailObj(emailObj, Test2.emailList)){
                        System.out.printf("Sending wishes to %s...\n",name);
                        Email_Sending.sendMail(emailAddress,subject, content);
                        Test2.emailList = Create_ArrayList.createTheArrayList(emailObj, "emails.ser");
                    }
                }
            }
        }
    }
}
