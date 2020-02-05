import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Volunteer> Volunteers = load();
        Volunteer volunteer = start();
        Volunteers.add(volunteer);
        save(Volunteers);

    }

    public static Volunteer start() {
        ArrayList<String> programNames = new ArrayList<String>();
        programNames.add("Worship");
        programNames.add("Welcome");
        programNames.add("Production");
        programNames.add("Community Groups");
        programNames.add("Childrens Ministry");
        programNames.add("Student Ministry");
        System.out.println("Your involvement matters because your service makes a difference");
        System.out.println("First Name: ");
        String firstName = in.nextLine();
        System.out.println("Last Name: ");
        String lastName = in.nextLine();
        System.out.println("Phone: ");
        String phone = in.nextLine();
        System.out.println("Email: ");
        String email = in.nextLine();
        for (String programName : programNames) {
            System.out.println("-------");
            System.out.println(programName);
            System.out.println("-------");
        }
        System.out.println("Which will be your first choice");
        String firstChoice = in.nextLine();
        if (programNames.contains(firstChoice)) {
            System.out.println("Which will be your second choice");
            String secondChoice = in.nextLine();
            if (programNames.contains(secondChoice)) {
                System.out.println(" ");
                System.out.println("------------------");
                System.out.println(firstName + " " + lastName);
                System.out.println(phone);
                System.out.println(email);
                System.out.println("First choice is -> " + firstChoice);
                System.out.println("Second choice is -> " + secondChoice);
                System.out.println("-------------------");
                return new Volunteer(firstName, lastName, phone, email, firstChoice, secondChoice);
            }
        } else {
        }
        return null;
    }

    public static ArrayList<Volunteer> load() {
        try {
            FileInputStream fileStream = new FileInputStream("Volunteers.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Volunteer> volunteers = (ArrayList<Volunteer>) os.readObject();
            os.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Volunteer>();
        }
    }

    private static void save(ArrayList<Volunteer> volunteers) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("Volunteers.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);
            objectOut.writeObject(volunteers);
            objectOut.close();
        } catch (IOException ex) {
            System.out.println("Hate to say it , but somethings broken");
        }
    }
}