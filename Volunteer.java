import java.io.Serializable;

public class Volunteer implements Serializable {
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String phone;
    String email;
    String firstChoice;
    String secondChoice;

    public Volunteer(String firstName, String lastName, String phone, String email, String firstChoice,
            String secondChoice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;

    }

}