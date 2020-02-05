import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Volunteer> Volunteers = load();
        ArrayList<String> programNames = new ArrayList<String>();
        programNames.add("Worship");
        programNames.add("Welcome");
        programNames.add("Production");
        programNames.add("Community Groups");
        programNames.add("Children's Ministry");
        programNames.add("Student Ministry");
        for (String programName : programNames) {
            System.out.println("_______________");
            System.out.println(" ");
            System.out.println(programName);
            for (final Volunteer volunteer : Volunteers) {
                if (programName.contains(volunteer.firstChoice)) {
                    System.out.println(" ");
                    System.out.println(volunteer.firstName + "'s first choice is " + programName);
                }
                if (volunteer.firstChoice != volunteer.secondChoice && programName.contains(volunteer.secondChoice)) {
                    System.out.println(volunteer.firstName + "'s second choice is " + programName);
                }
            }
        }
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
}