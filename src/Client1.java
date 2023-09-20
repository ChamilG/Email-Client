import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Client1 {
    String name, birthday, designation;
    public Client1(String name, String birthday, String designation){
        this.name = name;
        this.birthday = birthday;
        this.designation = designation;
        printIn();
    }
    public void printIn(){
        try(FileWriter fw = new FileWriter("myfile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            String input = String.format("Official:%s,%s,%s",name,birthday, designation);
            out.println(input);
            //more code
            //out.println("more text");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
 }