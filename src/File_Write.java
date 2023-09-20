import java.io.*;
import java.util.ArrayList;

/*public class File_Write {
    public static void  writeToFile(String my_file_name, String write) throws IOException {
        FileWriter fileWriter = new FileWriter(my_file_name, true);
        BufferedWriter file = new BufferedWriter(fileWriter);
        file.write(String.format("%s\n",write));
        file.close();
        fileWriter.close();
    }

    public static void readFromFile(ArrayList<Recip_ients> recipients, String my_file_name){
        try{
            FileReader fileReader = new FileReader(my_file_name);
            BufferedReader file = new BufferedReader(fileReader);
            Recipients_Factory recipientsFactory = new Recipients_Factory();
            Recip_ients recipient = null;
            String line = null;

            while((line = file.readLine()) != null){
                String[] recipientType = line.split(":");
                //System.out.println(recipientType[0]);
                recipientsFactory.list = recipientType[1].split(",");
                recipient = recipientsFactory.createRecipient(recipientType[0].strip());
                recipients.add(recipient);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}*/
