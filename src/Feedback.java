import java.text.SimpleDateFormat;
import java.util.Date;

// ENCAPSULATION: This class encapsulates all data related to professional feedback
// IMMUTABILITY: All fields are final, ensuring data cannot be modified after creation
public class Feedback {

    // ENCAPSULATION: Private final fields ensure data integrity and immutability
    private final String professionalName;
    private final String professionalType;
    private final String message;
    private final Date timestamp;
    
    // ENCAPSULATION: Constructor with automatic timestamp
    public Feedback(String professionalName, String professionalType, String message) {
        this.professionalName = professionalName;
        this.professionalType = professionalType;
        this.message = message;
        this.timestamp = new Date();
    }
    
    // ENCAPSULATION: Getter methods provide read-only access
    public String getProfessionalName() {
        return professionalName;
    }
    
    public String getProfessionalType() {
        return professionalType;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    // ENCAPSULATION: Method hiding timestamp formatting logic
    public String getFormattedTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }
    
    // POLYMORPHISM: Override toString() from Object
    // METHOD OVERRIDING: Custom representation for Feedback objects
    @Override
    public String toString() {
        return String.format("\n[%s]\nFrom: %s (%s)\nMessage: %s\n%s", 
            getFormattedTimestamp(),
            professionalName,
            professionalType,
            message,
            "=".repeat(60));
    }
}
