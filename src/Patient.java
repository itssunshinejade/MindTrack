import java.util.Scanner;
import java.util.ArrayList;

// INHERITANCE: Patient extends User, inheriting common user properties and behaviors
// POLYMORPHISM: Patient provides its own implementation of the abstract displayMenu() method
public class Patient extends User {

    // COMPOSITION: Patient HAS-A MentalHealthProfile
    // ENCAPSULATION: Final field prevents reassignment
    private final MentalHealthProfile mentalHealth;

    // COMPOSITION: Patient HAS-A PhysicalHealthProfile
    private final PhysicalHealthProfile physicalHealth;

    // COMPOSITION: Patient HAS-A collection of Feedback objects
    // ENCAPSULATION: Private field with controlled access
    private final ArrayList<Feedback> feedbackList;

    // INHERITANCE: Constructor calls superclass via super()
    // ENCAPSULATION: Ensures proper initialization
    public Patient(String id, String name, String email, String password) {
        super(id, name, email, password);
        this.mentalHealth = new MentalHealthProfile();
        this.physicalHealth = new PhysicalHealthProfile();
        this.feedbackList = new ArrayList<>();
    }

    // POLYMORPHISM: Overrides abstract method from User
    @Override
    public void displayMenu() {
        Scanner sc = Main.getScanner();

        while (true) {
            System.out.println("\n=== PATIENT MENU ===");
            System.out.println("Welcome, " + name + "!");
            System.out.println("[1] Log Mood");
            System.out.println("[2] Log Stress");
            System.out.println("[3] Log Vitals");
            System.out.println("[4] ViewMental History");
            System.out.println("[5] ViewPhysical History");
            System.out.println("[6] ViewFeedback");
            System.out.println("[7] ViewAllRecords");
            System.out.println("[0] Logout");
            System.out.print("\nChoice: ");

            try {
                if (sc.hasNextLine()) {
                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1 -> logMood(sc);
                        case 2 -> logStress(sc);
                        case 3 -> logVitals(sc);
                        case 4 -> mentalHealth.displayHistory();       // COMPOSITION
                        case 5 -> physicalHealth.displayHistory();      // COMPOSITION
                        case 6 -> viewFeedback();
                        case 7 -> viewAllRecords();
                        case 0 -> {
                            System.out.println("Logging out...\n");
                            return;
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                } else {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    // ENCAPSULATION: Private method, not accessible outside this class
    private void viewAllRecords() {
        System.out.println("\n=== COMPREHENSIVE HEALTH RECORDS ===");
        System.out.println("Patient: " + name);
        System.out.println("ID: " + id);
        System.out.println("=" + "=".repeat(50));

        // COMPOSITION: Access composed objects
        System.out.println("\n--- MENTAL HEALTH SUMMARY ---");
        mentalHealth.displayHistory();

        System.out.println("\n--- PHYSICAL HEALTH SUMMARY ---");
        physicalHealth.displayHistory();

        System.out.println("\n--- PROFESSIONAL FEEDBACK SUMMARY ---");
        if (feedbackList.isEmpty()) {
            System.out.println("No professional feedback received yet.");
        } else {
            System.out.println("Total feedback received: " + feedbackList.size());
            for (Feedback feedback : feedbackList) {
                System.out.println("• " + feedback.getProfessionalType() + " " +
                                   feedback.getProfessionalName() + " (" +
                                   feedback.getFormattedTimestamp() + ")");
            }
        }
        System.out.println("=" + "=".repeat(50));
    }

    // ENCAPSULATION: Private mood logging functionality
    private void logMood(Scanner sc) {
        clearSection();
        System.out.println("MOOD LOGGING");
        System.out.print("Mood (1-10): ");

        try {
            int mood = Integer.parseInt(sc.nextLine());
            if (mood >= 1 && mood <= 10) {
                mentalHealth.addMoodEntry(mood);     // COMPOSITION
                provideMoodFeedback(mood);
            } else {
                System.out.println("Range: 1-10");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }

        System.out.print("\nPress Enter...");
        if (sc.hasNextLine()) sc.nextLine();
    }

    // ENCAPSULATION: Private stress logging
    private void logStress(Scanner sc) {
        clearSection();
        System.out.println("STRESS LOGGING");
        System.out.print("Stress (1-10): ");

        try {
            int stress = Integer.parseInt(sc.nextLine());
            if (stress >= 1 && stress <= 10) {
                mentalHealth.addStressEntry(stress);   // COMPOSITION
                provideStressFeedback(stress);
            } else {
                System.out.println("Range: 1-10");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
        }

        System.out.print("\nPress Enter...");
        if (sc.hasNextLine()) sc.nextLine();
    }

    // ENCAPSULATION: Private vitals logging
    private void logVitals(Scanner sc) {
        clearSection();
        System.out.println("VITALS LOGGING");

        try {
            System.out.print("Heart Rate: ");
            int heartRate = Integer.parseInt(sc.nextLine());

            System.out.print("Blood Pressure: ");
            int bloodPressure = Integer.parseInt(sc.nextLine());

            System.out.print("Blood Sugar: ");
            int bloodSugar = Integer.parseInt(sc.nextLine());

            physicalHealth.addVitalsEntry(heartRate, bloodPressure, bloodSugar); // COMPOSITION
            provideVitalsFeedback(heartRate, bloodPressure, bloodSugar);

        } catch (NumberFormatException e) {
            System.out.println("Invalid numbers");
        }

        System.out.print("\nPress Enter...");
        if (sc.hasNextLine()) sc.nextLine();
    }

    // ENCAPSULATION: Private method for displaying feedback
    private void viewFeedback() {
        System.out.println("\n=== Professional Feedback ===");

        if (feedbackList.isEmpty()) {
            System.out.println("No feedback received yet.");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println("\nFrom: " + feedback.getProfessionalName() +
                                   " (" + feedback.getProfessionalType() + ")");
                System.out.println("Date: " + feedback.getFormattedTimestamp());
                System.out.println("Message: " + feedback.getMessage());
                System.out.println("-".repeat(50));
            }
        }
    }

    // ENCAPSULATION: Public controlled access for adding feedback
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    // ENCAPSULATION: Public getters giving safe access
    public MentalHealthProfile getMentalHealth() {
        return mentalHealth;
    }

    public PhysicalHealthProfile getPhysicalHealth() {
        return physicalHealth;
    }

    // ENCAPSULATION: Private UI helper
    private void clearSection() {
        System.out.println("\n" + "=".repeat(50));
    }

    // ENCAPSULATION: Private helper methods for generating feedback
    private void provideMoodFeedback(int mood) {
        if (mood >= 8) {
            System.out.println("Great to see you're feeling positive!");
        } else if (mood >= 6) {
            System.out.println("You're doing well today!");
        } else if (mood >= 4) {
            System.out.println("Hope your day gets better!");
        } else {
            System.out.println("Take care of yourself.");
        }
    }

    private void provideStressFeedback(int stress) {
        if (stress <= 3) {
            System.out.println("Excellent! You're managing stress well!");
        } else if (stress <= 5) {
            System.out.println("Moderate stress level.");
        } else if (stress <= 7) {
            System.out.println("Higher stress detected.");
        } else {
            System.out.println("High stress level.");
        }
    }

    private void provideVitalsFeedback(int heartRate, int bloodPressure, int bloodSugar) {
        System.out.println("\n>>> Health Assessment:");

        if (heartRate >= 60 && heartRate <= 100)
            System.out.println("   Heart rate: Normal");
        else if (heartRate < 60)
            System.out.println("   Heart rate: Below normal");
        else
            System.out.println("   Heart rate: Above normal");

        if (bloodPressure <= 120)
            System.out.println("   Blood pressure: Optimal");
        else if (bloodPressure <= 139)
            System.out.println("   Blood pressure: Elevated");
        else
            System.out.println("   Blood pressure: High");

        if (bloodSugar >= 70 && bloodSugar <= 130)
            System.out.println("   Blood sugar: Normal");
        else if (bloodSugar < 70)
            System.out.println("   Blood sugar: Low");
        else
            System.out.println("   Blood sugar: High");
    }
}
