import java.time.LocalDateTime;
import java.io.*;
import java.util.*;

public class Subscription {

    public static void revenue(){
        String file = "C:\\Kodning\\Delfin\\src\\Accounting.txt";

        try{
                File filepath = new File(file);
                Scanner scan = new Scanner(filepath);
                int revenue = 0;
                while (scan.hasNextLine()){
                    String line = scan.nextLine();
                    int income = Integer.parseInt(line);
                    revenue += income;
                }
            System.out.println(revenue);
        } catch (IOException e){
            System.out.println("Error happened. " + e.getMessage());
        }
    }

}
