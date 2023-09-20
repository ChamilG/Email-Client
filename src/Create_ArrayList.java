import java.io.IOException;
import java.util.ArrayList;

public class Create_ArrayList {
    static ArrayList<Email> emailList = new ArrayList<Email>();
    public static ArrayList<Email> createTheArrayList(Email email, String file_name) throws IOException, ClassNotFoundException {

        emailList.add(email);

        return emailList;
    }
}
