// ABSTRACTION: Abstract class defining common structure for all user types
public abstract class User {

    // ENCAPSULATION: Protected fields accessible to subclasses
    protected String id;
    protected String name;
    protected String email;
    protected String password;

    // ENCAPSULATION: Controlled initialization through constructor
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // ENCAPSULATION: Getter methods for controlled access
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    // ABSTRACTION + POLYMORPHISM: Subclasses must implement their own menu
    public abstract void displayMenu();
}
