import java.text.SimpleDateFormat;
import java.util.Date;

// ENCAPSULATION: This class encapsulates health data with automatic timestamping
// IMMUTABILITY: Final fields ensure health records cannot be altered after creation
public class HealthEntry {

    // ENCAPSULATION: Private final fields protect data integrity
    private final String type;
    private final int value;
    private final String secondaryValue;
    private final Date timestamp;
    
    // CONSTRUCTOR OVERLOADING: Multiple constructors for different use cases
    public HealthEntry(String type, int value) {
        this.type = type;
        this.value = value;
        this.secondaryValue = "";
        this.timestamp = new Date();
    }
    
    // CONSTRUCTOR OVERLOADING: Overloaded constructor with additional info
    public HealthEntry(String type, int value, String secondaryValue) {
        this.type = type;
        this.value = value;
        this.secondaryValue = secondaryValue;
        this.timestamp = new Date();
    }
    
    // ENCAPSULATION: Getter methods provide read-only access
    public String getType() {
        return type;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getSecondaryValue() {
        return secondaryValue;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    // ENCAPSULATION: Method encapsulates timestamp formatting logic
    public String getFormattedTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }
    
    // POLYMORPHISM: Override toString() method
    // METHOD OVERRIDING: Custom string representation of HealthEntry
    @Override
    public String toString() {
        if (secondaryValue.isEmpty()) {
            return String.format("[%s] %s: %d", getFormattedTimestamp(), type, value);
        } else {
            return String.format("[%s] %s: %d (%s)", getFormattedTimestamp(), type, value, secondaryValue);
        }
    }
}
