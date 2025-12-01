import java.util.Scanner;

// INHERITANCE: Doctor extends Professional
// POLYMORPHISM: Doctor provides specialized implementation
public class Doctor extends Professional {
    
    // INHERITANCE: Constructor delegates to parent class
    public Doctor(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    // POLYMORPHISM: Override abstract displayMenu() method
    // METHOD OVERRIDING: Doctor-specific menu implementation
    @Override
    public void displayMenu() {
        Scanner sc = Main.getScanner();
        
        while (true) {
            System.out.println("\n=== DOCTOR MENU ===");
            System.out.println("Welcome, " + name + "!");
            System.out.println("[1] View Patient Physical Vitals");
            System.out.println("[2] Give Medical Advice");
            System.out.println("[0] Logout");
            System.out.print("\nEnter your choice: ");
            
            try {
                if (sc.hasNextLine()) {
                    int choice = Integer.parseInt(sc.nextLine());
                    
                    switch (choice) {
                        case 1 -> viewPatientSummary();
                        case 2 -> giveFeedback();
                        case 0 -> {
                            System.out.println("Logging out...\n");
                            return;
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Input stream closed. Exiting...");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // POLYMORPHISM: Override abstract method from Professional
    // METHOD OVERRIDING: Doctor-specific patient information display
    @Override
    protected void displayPatientInfo(Patient patient) {
        System.out.println("\n=== Physical Health Report for: " + patient.getName() + " ===");
        
        // ENCAPSULATION: Access physical health using getters
        PhysicalHealthProfile physical = patient.getPhysicalHealth();
        
        System.out.println("Current Heart Rate: " + physical.getCurrentHeartRate() + " bpm");
        System.out.println("Current Blood Pressure: " + physical.getCurrentBloodPressure() + " mmHg");
        System.out.println("Current Blood Sugar: " + physical.getCurrentBloodSugar() + " mg/dL");
    }
}
