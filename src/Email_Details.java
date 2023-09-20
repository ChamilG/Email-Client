import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Email_Details {
    public static void findEmailDetail(ArrayList<Email> emailList, String[] date) {
        String year = date[0], month = date[1], day = date[2];
        boolean noMail = true;
        for (Email email : emailList) {
            String dateSend = email.date.format(DateTimeFormatter.ISO_DATE);
            String[] month_and_Date_dateSend = dateSend.split("-");
            if (month_and_Date_dateSend[0].equals(year) && month_and_Date_dateSend[1].equals(month) && month_and_Date_dateSend[2].equals(day)) {
                Pr_int.printDetails(email);
                noMail = false;
            }
        }
        if (noMail) {
            System.out.printf("No Mails on %s/%s/%s\n", year, month, day);
        }
    }
}
