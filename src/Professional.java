import java.util.ArrayList;
import java.util.Scanner;

// INHERITANCE: Professional extends User, inheriting common user data and behavior
// ABSTRACTION: Abstract class representing all healthcare professionals
public abstract class Professional extends User {

    // INHERITANCE: Calls constructor of the superclass User
    public Professional(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    // ENCAPSULATION: Protected method only accessible within this class and subclasses
    protected void viewPatientSummary() {

        // COMPOSITION: Professional works with a list of Patients
        ArrayList<Patient> patients = Main.getPatients();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n=== Patient List ===");
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            System.out.println("[" + (i + 1) + "] " + p.getName() + " (ID: " + p.getId() + ")");
        }

        System.out.print("Select patient number: ");
        Scanner sc = Main.getScanner();

        try {
            int choice = Integer.parseInt(sc.nextLine()) - 1;

            if (choice >= 0 && choice < patients.size()) {
                Patient selected = patients.get(choice);

                // POLYMORPHISM: Calls subclass-specific implementation
                displayPatientInfo(selected);
            } else {
                System.out.println("Invalid selection.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // ENCAPSULATION: Method hides feedback-sending process from external classes
    protected void giveFeedback() {

        ArrayList<Patient> patients = Main.getPatients();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n=== Select Patient for Feedback ===");
        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            System.out.println("[" + (i + 1) + "] " + p.getName() + " (ID: " + p.getId() + ")");
        }

        System.out.print("Select patient number: ");
        Scanner sc = Main.getScanner();

        try {
            int choice = Integer.parseInt(sc.nextLine()) - 1;

            if (choice >= 0 && choice < patients.size()) {
                Patient selected = patients.get(choice);

                System.out.print("Feedback: ");
                String message = sc.nextLine();

                // POLYMORPHISM: Identifies the actual subclass at runtime
                String professionalType = getClass().getSimpleName();

                // COMPOSITION: Professional creates and attaches Feedback to Patient
                Feedback feedback = new Feedback(name, professionalType, message);
                selected.addFeedback(feedback);

                System.out.println("\n" + "=".repeat(50));
                System.out.println("[+] FEEDBACK SENT SUCCESSFULLY");
                System.out.println("=".repeat(50));
                System.out.println("To: " + selected.getName());
                System.out.println("From: " + name + " (" + professionalType + ")");
                System.out.println("Message: \"" + message + "\"");
                System.out.println("=".repeat(50));

                System.out.print("\nPress Enter...");
                sc.nextLine();

            } else {
                System.out.println("Invalid selection.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // ABSTRACTION: Subclasses must implement their own version
    // POLYMORPHISM: Therapist and Doctor show different patient data
    protected abstract void displayPatientInfo(Patient patient);
}
