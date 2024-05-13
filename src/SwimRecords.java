import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.*;
import java.util.*;
import java.time.LocalTime;
public class SwimRecords {

    int id;
    LocalDateTime recordDate;
    LocalTime swimTime;


    public static ArrayList<SwimRecords> juniorButterfly = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> juniorCrawl = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> juniorBackcrawl = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> juniorBreaststroke = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> seniorButterfly = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> seniorCrawl = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> seniorBackcrawl = new ArrayList<SwimRecords>();
    public static ArrayList<SwimRecords> seniorBreaststroke = new ArrayList<SwimRecords>();

    public SwimRecords(int id, LocalDateTime recordDate, LocalTime swimTime){
        this.id = id;
        this.recordDate = recordDate;
        this.swimTime = swimTime;

    }

    public String toString(){
        return "ID of swimmer: " + id + " Record date of record: " + recordDate + " Record time of the record: " + swimTime;
    }


    public static void readFromFile(){

        ArrayList<SwimRecords> arraySwim = new ArrayList<SwimRecords>();
        String file = "C:\\Kodning\\Delfin\\src\\SwimmingRecords.txt";
        try{
            File filepath = new File(file);
            Scanner scan = new Scanner(filepath);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if (line.contains("1600")){

                    String[] parts = line.split(" ");
                    int id = Integer.parseInt(parts[2]);
                    String date = parts[3];
                    String formattedDate = date.replace("T00:00", "");
                    String[] partsNew = formattedDate.split("-");
                    int year = Integer.parseInt(partsNew[0]);
                    int month = Integer.parseInt(partsNew[1]);
                    int day = Integer.parseInt(partsNew[2]);
                    LocalDateTime recordDate = LocalDateTime.of(year, month, day, 0, 0);

                    String time = parts[4];
                    String[] newTime = time.split(":");
                    int minute = Integer.parseInt(newTime[1]);
                    int second = Integer.parseInt(newTime[2]);
                    LocalTime recordTime = LocalTime.of(0, minute, second);
                    if (parts[0].contains("butterfly")){
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        seniorButterfly.add(record);
                    } else if (parts[0].contains("Crawl")){
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                         seniorCrawl.add(record);
                    } else if (parts[0].contains("Backcrawl")){
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        seniorBackcrawl.add(record);
                    } else if (parts[0].contains("Breaststroke")){
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        seniorBreaststroke.add(record);
                    }


                } else if (line.contains("1000")) {

                    String[] parts = line.split(" ");
                    int id = Integer.parseInt(parts[2]);
                    String date = parts[3];
                    String formattedDate = date.replace("T00:00", "");
                    String[] partsNew = formattedDate.split("-");
                    int year = Integer.parseInt(partsNew[0]);
                    int month = Integer.parseInt(partsNew[1]);
                    int day = Integer.parseInt(partsNew[2]);
                    LocalDateTime recordDate = LocalDateTime.of(year, month, day, 0, 0);

                    String time = parts[4];
                    String[] newTime = time.split(":");
                    int minute = Integer.parseInt(newTime[1]);
                    int second = Integer.parseInt(newTime[2]);
                    LocalTime recordTime = LocalTime.of(0, minute, second);
                    if (parts[0].contains("Butterfly")) {
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        juniorButterfly.add(record);
                    } else if (parts[0].contains("Crawl")) {
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        juniorCrawl.add(record);
                    } else if (parts[0].contains("Backcrawl")) {
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        juniorBackcrawl.add(record);
                    } else if (parts[0].contains("Breaststroke")) {
                        SwimRecords record = new SwimRecords(id, recordDate, recordTime);
                        juniorBreaststroke.add(record);
                    }

                }
            }


        } catch (IOException e){
            System.out.println("Error happened. " + e.getMessage());
        }


    }




}
