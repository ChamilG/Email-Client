import java.io.*;
import java.util.ArrayList;

public class Byte_File {
    public static void serialize(ArrayList<Email> List, String file_name) throws IOException {

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
}
