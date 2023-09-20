import java.util.ArrayList;

public class Pr_int {
    public static void printDetails(Email email){
        System.out.printf("You have send an email to %s,\n subject : %s,\n content : %s\n on this day\n",email.emailAddress, email.subject, email.content);
    }

    public static void printRecipientsWithBirthdays(ArrayList<Recip_ients> recipientList, String[] date){
        String  month = date[1], day = date[2];
        System.out.printf("on %s/%s/%s\n", date[0],date[1], date[2]);
        boolean haveBirthday = false;
        for(Recip_ients recipients:recipientList){
            if(!(recipients instanceof Official)){
                if(recipients instanceof Office_friend){
                    Office_friend office_friend = (Office_friend) recipients;
                    String[] Birthday = office_friend.birthday.split("/");
                    if(Birthday[1].equals(date[1]) && Birthday[2].equals(date[2])){
                        System.out.printf("%s has birthday\n",office_friend.name);
                        haveBirthday = true;
                    }
                }
                else {
                    Personal personal = (Personal) recipients;
                    String[] Birthday = personal.birthday.split("/");
                    if(Birthday[1].equals(date[1]) && Birthday[2].equals(date[2])){
                        System.out.printf("%s has birthday\n",personal.name);
                        haveBirthday = true;
                    }
                }
            }
        }
        if(!haveBirthday){
            System.out.println("No birthdays");
        }

    }
}
