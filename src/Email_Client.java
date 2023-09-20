/*// your index number*/
/*
import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Email_Client {
    static ArrayList<Email> emailList = new ArrayList<Email>();
    static LocalDate date = LocalDate.now();

    /*public static void main(String[] args) throws IOException, MessagingException, ClassNotFoundException {

        //CHECK THE FOLLOWING LINES
        emailList = ByteFile.deSerialiaze("email.ser");
        // System.out.println(emailList.get(0).content);
        ArrayList<Recipients> recipientsList = new ArrayList<Recipients>();
        Filewrite.readFromFile(recipientsList, "clientList.txt");
        BirthdayWish.birthdayWish(recipientsList, date);

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
            RecipientsFactory recipientsFactory = new RecipientsFactory();
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
                    Recipients recipient = recipientsFactory.createRecipient(recipientType[0].strip());
                    Filewrite.writeToFile("clientList.txt", inputDetails);
                    recipientsList.add(recipient);
                    BirthdayWish.birthdayWish(recipientsList, date);

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
                    EmailSending.sendMail(emailAddress, subject, content);
                    Email email = new Email(emailAddress, subject, content, date);
                    emailList = CreateArrayList.createTheArrayList(email, "emails.ser");
                    //serialize(emailList, "email1.ser");
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    Scanner scanner3 = new Scanner(System.in);
                    String date_Today = scanner3.nextLine();
                    String[] Date = date_Today.split("/");
                    Print.printRecipientsWithBirthdays(recipientsList, Date);

                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    Scanner scanner4 = new Scanner(System.in);
                    String dateToday = scanner4.nextLine();
                    String[] date = dateToday.split("/");

                    EmailDetails.findEmailDetail(emailList, date);

                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    // System.out.println(RecipientsFactory.recipients.size());
                    System.out.println(RecipientsFactory.noOfRecipients);
                    break;
                case 6:
                    bool = false;
            }

            ByteFile.serialize(emailList, "email.ser");
            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes

        }
    }
}*/
// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)