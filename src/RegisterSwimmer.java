import java.time.LocalDateTime;
import java.io.*;
import java.util.*;


public class RegisterSwimmer {
    String name;
    public static int IDCount = 20;
    int id;
    String address;
    int phoneNumber;
    String email;
    boolean gender; // true female, false male
    boolean payment;
    LocalDateTime birthDate;

    public static ArrayList<RegisterSwimmer> swimmersArray = new ArrayList<RegisterSwimmer>();


    public RegisterSwimmer(String name, int id, String address, int phoneNumber, String email,
                        boolean gender, boolean payment, LocalDateTime birthDate){
        this.name = name;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.payment = payment;
        this.birthDate = birthDate;
    }


    public String toString(){
        return " " + "ID: " + id + " Name: " + name + "\n" + "Address: " + address + " phone number: " + phoneNumber +
                "email: " + email + "\n" + "Gender: " +
                gender + " Payment: " + payment + " Birthdate: " + birthDate + "\n";
    }


    public static void readFromFile(){
        String file = "C:\\Kodning\\Delfin\\src\\Members.txt";

        try{
            File filPath = new File(file);
            Scanner scan = new Scanner(filPath);

            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                if (parts[0].contains("1600")){

                    int price = Integer.parseInt(parts[0]);
                    int id = Integer.parseInt(parts[1]);
                    String fullName = parts[2] + parts[3];
                    String nextLine = scan.nextLine();
                    int index = nextLine.indexOf("|");
                    String address = nextLine.substring(0, index);
                    String partLine = nextLine.substring(index);
                    String[] nextLineParts = partLine.split(" ");
                    String num = nextLineParts[0];
                    int phoneNum = Integer.parseInt(num.replace("|", ""));
                    String mail = nextLineParts[1];
                    boolean gender = Boolean.parseBoolean(nextLineParts[2]);
                    boolean payment = Boolean.parseBoolean(nextLineParts[3]);
                    if (payment){
                        writeToAccounting(price);
                    }
                    String thirdLine = scan.nextLine();
                    String[] thirdLineParts = thirdLine.split(" ");
                    String date = thirdLineParts[0];
                    String newDate = date.replace("T00:00", "");
                    String[] completeDate = newDate.split("-");
                    int year = Integer.parseInt(completeDate[0]);
                    int month = Integer.parseInt(completeDate[1]);
                    int day = Integer.parseInt(completeDate[2]);
                    LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
                    boolean competitive = Boolean.parseBoolean(thirdLineParts[1]);
                    Senior swimmer = new Senior(fullName, id, address, phoneNum, mail, gender, payment, birthDate, price, competitive);
                    swimmersArray.add(swimmer);

                } else if (parts[0].contains("1000")){

                    int price = Integer.parseInt(parts[0]);
                    int id = Integer.parseInt(parts[1]);
                    String fullName = parts[2] + parts[3];
                    String nextLine = scan.nextLine();
                    int index = nextLine.indexOf("|");
                    String address = nextLine.substring(0, index);
                    String partLine = nextLine.substring(index);
                    String[] nextLineParts = partLine.split(" ");
                    String num = nextLineParts[0];
                    int phoneNum = Integer.parseInt(num.replace("|", ""));
                    String mail = nextLineParts[1];
                    boolean gender = Boolean.parseBoolean(nextLineParts[2]);
                    boolean payment = Boolean.parseBoolean(nextLineParts[3]);
                    if (payment){
                        writeToAccounting(price);
                    }
                    String thirdLine = scan.nextLine();
                    String[] thirdLineParts = thirdLine.split(" ");
                    String date = thirdLineParts[0];
                    String newDate = date.replace("T00:00", "");
                    String[] completeDate = newDate.split("-");
                    int year = Integer.parseInt(completeDate[0]);
                    int month = Integer.parseInt(completeDate[1]);
                    int day = Integer.parseInt(completeDate[2]);
                    LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
                    boolean competitive = Boolean.parseBoolean(thirdLineParts[1]);
                    Junior swimmer = new Junior(fullName, id, address, phoneNum, mail, gender, payment, birthDate, price, competitive);
                    swimmersArray.add(swimmer);

                } else if (parts[0].contains("1200")){
                    int price = Integer.parseInt(parts[0]);

                    int id = Integer.parseInt(parts[1]);
                    String fullName = parts[2] + parts[3];
                    String nextLine = scan.nextLine();
                    int index = nextLine.indexOf("|");
                    String address = nextLine.substring(0, index);
                    String partLine = nextLine.substring(index);
                    String[] nextLineParts = partLine.split(" ");
                    String num = nextLineParts[0];
                    int phoneNum = Integer.parseInt(num.replace("|", ""));
                    String mail = nextLineParts[1];
                    boolean gender = Boolean.parseBoolean(nextLineParts[2]);
                    boolean payment = Boolean.parseBoolean(nextLineParts[3]);
                    if (payment){
                        writeToAccounting(price);
                    }
                    String thirdLine = scan.nextLine();
                    String[] thirdLineParts = thirdLine.split(" ");
                    String date = thirdLineParts[0];
                    String newDate = date.replace("T00:00", "");
                    String[] completeDate = newDate.split("-");
                    int year = Integer.parseInt(completeDate[0]);
                    int month = Integer.parseInt(completeDate[1]);
                    int day = Integer.parseInt(completeDate[2]);
                    LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
                    Senior60Plus swimmer = new Senior60Plus(fullName, id, address, phoneNum, mail, gender, payment, birthDate, price);
                    swimmersArray.add(swimmer);

                } else if (parts[0].contains("500")){

                    int price = Integer.parseInt(parts[0]);
                    int id = Integer.parseInt(parts[1]);
                    String fullName = parts[2] + parts[3];
                    String nextLine = scan.nextLine();
                    int index = nextLine.indexOf("|");
                    String address = nextLine.substring(0, index);
                    String partLine = nextLine.substring(index);
                    String[] nextLineParts = partLine.split(" ");
                    String num = nextLineParts[0];
                    int phoneNum = Integer.parseInt(num.replace("|", ""));
                    String mail = nextLineParts[1];
                    boolean gender = Boolean.parseBoolean(nextLineParts[2]);
                    boolean payment = Boolean.parseBoolean(nextLineParts[3]);
                    if (payment){
                        writeToAccounting(price);
                    }
                    String thirdLine = scan.nextLine();
                    String[] thirdLineParts = thirdLine.split(" ");
                    String date = thirdLineParts[0];
                    String newDate = date.replace("T00:00", "");
                    String[] completeDate = newDate.split("-");
                    int year = Integer.parseInt(completeDate[0]);
                    int month = Integer.parseInt(completeDate[1]);
                    int day = Integer.parseInt(completeDate[2]);
                    LocalDateTime birthDate = LocalDateTime.of(year, month, day, 0, 0);
                    Passiv swimmer = new Passiv(fullName, id, address, phoneNum, mail, gender, payment, birthDate, price);
                    swimmersArray.add(swimmer);

                }
            }

        } catch (IOException e){
            System.out.println("Error happened. " + e.getMessage());
        }


    }


    public static void writeToAccounting(int price){

        try{
            FileWriter writer = new FileWriter("C:\\Kodning\\Delfin\\src\\Accounting.txt", true);
            String writeToFile = price + "\n";
            writer.write(writeToFile);
            System.out.println("Written accounting to file aswell");
            writer.close();
        } catch (IOException e){
            System.out.println("Error happened. " + e.getMessage());
        }
    }



}



