import javax.mail.MessagingException;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/*public class test {
    static ArrayList<Email> emailList = new ArrayList<Email>();
    static LocalDate date = LocalDate.now();
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

                    if(checkEmailObj(emailObj, emailList)){
                        System.out.printf("Sending wishes to %s...\n",name);
                        Email_Sending.sendMail(emailAddress,subject, content);
                        emailList = createTheArrayList(emailObj, "emails.ser");
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
                    if(checkEmailObj(emailObj, emailList)){
                        System.out.printf("Sending wishes to %s...\n",name);
                        Email_Sending.sendMail(emailAddress,subject, content);
                        emailList = createTheArrayList(emailObj, "emails.ser");
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException, MessagingException, ClassNotFoundException {

        //CHECK THE FOLLOWING LINES
        emailList = deSerialiaze("email.ser");
       // System.out.println(emailList.get(0).content);
        ArrayList<Recip_ients> recipientsList = new ArrayList<Recip_ients>();
        File_Write.readFromFile(recipientsList, "clientList.txt");
       birthdayWish(recipientsList, date);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application\n"
                + "6 - Exit");

        boolean bool = true;
        while (bool) {

            int option = scanner.nextInt();
            Recipients_Factory recipientsFactory = new Recipients_Factory();
            switch (option) {
                case 1:
                    // input format - Official: nimal,nimal@gmail.com,ceo
                    //Personal: sunil<nickname>,email,2000/08/10
                    //Office_friend: Kamal, kamal@gmail.com, cerlk, 2000/12/12
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file
                    // Hint: use methods for reading and writing files
                    System.out.println("Enter the recipient : ");
                    Scanner scanner1 = new Scanner(System.in);
                    String inputDetails = scanner1.nextLine();
                    String[] recipientType = inputDetails.split(":");
                    recipientsFactory.list = recipientType[1].split(",");
                    Recip_ients recipient = recipientsFactory.createRecipient(recipientType[0].strip());
                    File_Write.writeToFile("clientList.txt",inputDetails);
                    recipientsList.add(recipient);
                    birthdayWish(recipientsList,date);

                    break;
                case 2:
                    // input format - email, subject, content
                    // code to send an email
                    Scanner scanner2 = new Scanner(System.in);
                    String sendEmail = scanner2.nextLine();
                    String[] emailContent = sendEmail.strip().split(",");
                    String emailAddress = emailContent[0].strip();
                    String subject = emailContent[1].strip();
                    String content = emailContent[2].strip();
                    System.out.println("Sending...");
                    Email_Sending.sendMail(emailAddress, subject, content);
                    Email email = new Email(emailAddress, subject, content, date);
                    emailList = createTheArrayList(email, "emails.ser");
                    //serialize(emailList, "email1.ser");
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    Scanner scanner3 = new Scanner(System.in);
                    String date_Today = scanner3.nextLine();
                    String[] Date = date_Today.split("/");
                    printRecipientsWithBirthdays(recipientsList, Date);

                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    Scanner scanner4 = new Scanner(System.in);
                    String dateToday = scanner4.nextLine();
                    String[] date = dateToday.split("/");

                    findEmailDetail(emailList, date);

                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    // System.out.println(RecipientsFactory.recipients.size());
                    System.out.println(Recipients_Factory.noOfRecipients);
                    break;
                case 6:
                    bool = false;
            }

            serialize(emailList,"email.ser");
            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes

        }
    }
    public static void serialize(ArrayList<Email> List, String file_name) throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream(file_name);
        ObjectOutputStream file = new ObjectOutputStream(fileOutputStream);

        file.writeObject(List);
        file.close();
        fileOutputStream.close();
    }
    public static ArrayList<Email> deSerialiaze(String file_name) throws IOException, ClassNotFoundException {
        ArrayList<Email> List = new ArrayList<Email>();
        try{
            FileInputStream fileInputStream = new FileInputStream(file_name);
            ObjectInputStream file = new ObjectInputStream(fileInputStream);
            List = (ArrayList<Email>)file.readObject();
            file.close();
            fileInputStream.close();
        }
        catch(IOException e){
            System.out.println("First Time");
        }

        return List;
    }

    public static ArrayList<Email> createTheArrayList(Email email, String file_name) throws IOException, ClassNotFoundException {

        emailList.add(email);

        return emailList;
    }

   public static void findEmailDetail(ArrayList<Email> emailList, String[] date){
        String year = date[0], month = date[1], day = date[2];
        boolean noMail = true;
        for(Email email:emailList){
            String dateSend = email.date.format(DateTimeFormatter.ISO_DATE);
            String[] month_and_Date_dateSend = dateSend.split("-");
            if(month_and_Date_dateSend[0].equals(year) && month_and_Date_dateSend[1].equals(month) && month_and_Date_dateSend[2].equals(day)){
                Pr_int.printDetails(email);
                noMail = false;
            }
        }
        if(noMail){
            System.out.printf("No Mails on %s/%s/%s\n",year,month,day);
        }
    }

    public static void printDetails(Email email){
        System.out.printf("You have send an email to %s,\n subject : %s,\n content : %s\n on this day\n",email.emailAddress, email.subject, email.content);
    }

    public static void printRecipientsWithBirthdays(ArrayList<Recip_ients> recipientList, String[] date){
        String  month = date[1], day = date[2];
        System.out.printf("on %s/%s/%s\n", date[0],date[1], date[2]);
        for(Recip_ients recipients:recipientList){
            if(!(recipients instanceof Official)){
                if(recipients instanceof Office_friend){
                    Office_friend office_friend = (Office_friend) recipients;
                    String[] Birthday = office_friend.birthday.split("/");
                    if(Birthday[1].equals(date[1]) && Birthday[2].equals(date[2])){
                        System.out.printf("%s has birthday\n",office_friend.name);
                    }
                }
                else{
                    Personal personal = (Personal) recipients;
                    String[] Birthday = personal.birthday.split("/");
                    if(Birthday[1].equals(date[1]) && Birthday[2].equals(date[2])){
                        System.out.printf("%s has birthday\n",personal.name);
                    }
                }
            }
        }

    }

    public static boolean checkEmailObj(Email mail, ArrayList<Email> emailList) {
        boolean state = true;
        for(Email email:emailList){
            if(mail.emailAddress.equals(email.emailAddress) && mail.date.equals(email.date) && mail.subject.equals(email.subject) && mail.content.equals(email.content)){
                state = false;
            }
        }return state;
    }
}
*/