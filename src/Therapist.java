import java.util.Scanner;

// INHERITANCE: Therapist extends Professional (multi-level inheritance)
public class Therapist extends Professional {
    
    // INHERITANCE: Calls parent constructor
    public Therapist(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    // POLYMORPHISM & METHOD OVERRIDING: Therapist-specific menu implementation
    @Override
    public void displayMenu() {
        Scanner sc = Main.getScanner();
        
        while (true) {
            System.out.println("\n=== THERAPIST MENU ===");
            System.out.println("Welcome, " + name + "!");
            System.out.println("[1] View Patient Mental Health Stats");
            System.out.println("[2] Give Therapy Feedback");
            System.out.println("[0] Logout");
            System.out.print("\nEnter your choice: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                
                switch (choice) {
                    // INHERITANCE: Uses method from Professional class
                    case 1 -> viewPatientSummary();
                    case 2 -> giveFeedback();
                    case 0 -> {
                        System.out.println("Logging out...\n");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // POLYMORPHISM & METHOD OVERRIDING: Therapist-specific data display
    @Override
    protected void displayPatientInfo(Patient patient) {
        System.out.println("\n=== Mental Health Report for: " + patient.getName() + " ===");

        // COMPOSITION & ENCAPSULATION: Therapist accesses patient’s mental health profile
        MentalHealthProfile mental = patient.getMentalHealth();

        System.out.println("Current Mood: " + mental.getCurrentMood() + "/10");
        System.out.println("Average Mood: " + String.format("%.1f", mental.getAverageMood()) + "/10");
        System.out.println("Current Stress: " + mental.getCurrentStress() + "/10");
        System.out.println("Average Stress: " + String.format("%.1f", mental.getAverageStress()) + "/10");
    }
}
