import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    
    // Static method to provide access to the main Scanner instance
    // This prevents Scanner resource conflicts by using a single System.in Scanner
    public static Scanner getScanner() {
        return sc;
    }
    
    public static void main(String[] args) {
        seedAccounts();
        displayWelcome();
        while (true) {
            displayLoginScreen();
            System.out.println("1) Login");
            System.out.println("2) Sign up");
            System.out.println("3) Exit");
            System.out.print("Choose option (1-3): ");
            
            // Defensive Scanner handling to prevent NoSuchElementException
            if (!sc.hasNextLine()) {
                System.out.println("Input stream closed. Exiting application.");
                break;
            }
            
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    User loggedIn = login();
                    if (loggedIn != null) {
                        loggedIn.displayMenu();
                    }
                }
                case "2" -> signUp();
                case "3" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }
    }

    private static void signUp() {
        System.out.println("\n=== SIGN UP ===");
        System.out.println("Select role: 1) Patient  2) Therapist  3) Doctor");
        System.out.print("Choice (1-3): ");
        if (!sc.hasNextLine()) {
            System.out.println("Input stream unavailable.");
            return;
        }
        String roleChoice = sc.nextLine();

        System.out.print("ID (unique short id, e.g. p3): ");
        if (!sc.hasNextLine()) return;
        String id = sc.nextLine();

        System.out.print("Full name: ");
        if (!sc.hasNextLine()) return;
        String name = sc.nextLine();

        System.out.print("Email: ");
        if (!sc.hasNextLine()) return;
        String email = sc.nextLine();

        System.out.print("Password: ");
        if (!sc.hasNextLine()) return;
        String password = sc.nextLine();

        switch (roleChoice) {
            case "1" -> {
                Patient p = new Patient(id, name, email, password);
                patients.add(p);
                users.add(p);
                System.out.println("[+] Patient account created. You can now log in with that email.");
            }
            case "2" -> {
                Therapist t = new Therapist(id, name, email, password);
                users.add(t);
                System.out.println("[+] Therapist account created. You can now log in with that email.");
            }
            case "3" -> {
                Doctor d = new Doctor(id, name, email, password);
                users.add(d);
                System.out.println("[+] Doctor account created. You can now log in with that email.");
            }
            default -> System.out.println("Invalid role selection. Sign up cancelled.");
        }
    }
    
    private static void displayWelcome() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║                      MINDTRACK                        ║");
        System.out.println("║        Where Mental Clarity Meets Physical Vitality   ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.println("=".repeat(60));
    }
    
    private static void displayLoginScreen() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                        === LOGIN ===");
        System.out.println("=".repeat(60));
    }
    
    private static User login() {
        System.out.println("\n>>> LOGIN TO YOUR ACCOUNT");
        System.out.println("-".repeat(40));
        
        System.out.print("Email: ");
        if (!sc.hasNextLine()) {
            System.out.println("Input stream unavailable.");
            return null;
        }
        String email = sc.nextLine();
        
        System.out.print("Password: ");
        if (!sc.hasNextLine()) {
            System.out.println("Input stream unavailable.");
            return null;
        }
        String password = sc.nextLine();
        
        System.out.println();
        System.out.print(">>> Authenticating...");
        
        // Simulate brief processing time for better UX
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle interruption gracefully
        }
        
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    System.out.println(" Success!");
                    System.out.println();
                    System.out.println("\nWelcome back, " + user.getName() + "!");
                    System.out.println("Role: " + user.getClass().getSimpleName());
                    System.out.println();
                    return user;
                }
            }
        }
        
        System.out.println(" Failed [X]");
        System.out.println("[!] Invalid email or password. Please try again.");
        System.out.println();
        return null;
    }
    
    private static void seedAccounts() {
        Patient patient1 = new Patient("p1", "Mark Reyes", "mark@mail.com", "1234");
        Patient patient2 = new Patient("p2", "Sarah Johnson", "sarah@mail.com", "pass123");
        
        patients.add(patient1);
        patients.add(patient2);
        users.add(patient1);
        users.add(patient2);
        
        users.add(new Therapist("t1", "Dr. Alice Smith", "alice@mail.com", "pass"));
        users.add(new Doctor("d1", "Dr. John Brown", "john@mail.com", "admin"));
        
        
    }
    
    public static ArrayList<Patient> getPatients() {
        return patients;
    }
}

