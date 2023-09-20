import java.io.IOException;
import java.util.ArrayList;

/*public class Recipients_Factory {
    String[] list;
    public static int noOfRecipients;
    public static ArrayList<Recip_ients> recipients = new ArrayList<Recip_ients>();
    public Recip_ients createRecipient(String type)  {
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("Official")) {
            noOfRecipients += 1;
            String name = list[0].strip();
            String email = list[1].strip();
            String designation = list[2].strip();
            try{
                Recip_ients recipient = new Official(name, email, designation);
                recipients.add(recipient);
                return recipient;
            }
            catch(IOException e){
                e.printStackTrace();
            }
        } else if(type.equalsIgnoreCase("Office_friend")){
            noOfRecipients += 1;
            String name = list[0].strip();
            String email = list[1].strip();
            String designation = list[2].strip();
            String birthday = list[3].strip();
            try{
                Recip_ients recipient = new Office_friend(name, email, designation, birthday);
                recipients.add(recipient);
                return recipient;
            }
            catch (IOException e){
                e.printStackTrace();
            }


        } else if(type.equalsIgnoreCase("Personal")){
            noOfRecipients += 1;
            String name = list[0].strip();
            String nickname = list[1].strip();
            String email = list[2].strip();
            String birthday = list[3].strip();
            try{
                Recip_ients recipient = new Personal(name, nickname, email, birthday);
                recipients.add(recipient);
                return recipient;
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }

        return null;
    }

}*/
