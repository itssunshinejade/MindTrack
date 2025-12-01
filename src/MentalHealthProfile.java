import java.util.ArrayList;

// ENCAPSULATION: This class encapsulates all mental health data and related operations
// COMPOSITION: This class is composed into Patient objects (Patient HAS-A MentalHealthProfile)
// SINGLE RESPONSIBILITY: Handles only mental health data management
public class MentalHealthProfile {

    // ENCAPSULATION: Private final fields protect data integrity
    // COMPOSITION: ArrayList contains HealthEntry objects
    private final ArrayList<HealthEntry> moodHistory;
    private final ArrayList<HealthEntry> stressHistory;

    // ENCAPSULATION: Constructor initializes internal data structures
    public MentalHealthProfile() {
        this.moodHistory = new ArrayList<>();
        this.stressHistory = new ArrayList<>();
    }

    // ENCAPSULATION: Public method with input validation
    public void addMoodEntry(int mood) {
        if (mood >= 1 && mood <= 10) {
            moodHistory.add(new HealthEntry("mood", mood));
            System.out.println("Mood saved successfully!");

            if (mood <= 3) {
                System.out.println("Remember: It's okay to have difficult days. Consider reaching out to your therapist.");
            } else if (mood >= 8) {
                System.out.println("Great to see you're feeling positive!");
            }
        } else {
            System.out.println("Invalid mood level. Please enter 1-10.");
        }
    }

    // ENCAPSULATION: Public method for stress level logging
    public void addStressEntry(int stress) {
        if (stress >= 1 && stress <= 10) {
            stressHistory.add(new HealthEntry("stress", stress));
            System.out.println("Stress level saved successfully!");

            if (stress >= 8) {
                System.out.println("High stress detected. Consider relaxation techniques or speak with your therapist.");
            }
        } else {
            System.out.println("Invalid stress level. Please enter 1-10.");
        }
    }

    // ENCAPSULATION: Method encapsulates display logic
    public void displayHistory() {
        System.out.println("\n=== Mental Health Summary ===");

        System.out.println("\nMood History:");
        if (moodHistory.isEmpty()) {
            System.out.println("  No mood entries yet.");
        } else {
            for (HealthEntry entry : moodHistory) {
                System.out.println("  [" + entry.getFormattedTimestamp() + "] Mood: " + entry.getValue());
            }
            System.out.println("  Average Mood: " + getAverageMood() + "/10");
        }

        System.out.println("\nStress History:");
        if (stressHistory.isEmpty()) {
            System.out.println("  No stress entries yet.");
        } else {
            for (HealthEntry entry : stressHistory) {
                System.out.println("  [" + entry.getFormattedTimestamp() + "] Stress: " + entry.getValue());
            }
            System.out.println("  Average Stress: " + getAverageStress() + "/10");
        }
    }

    // ENCAPSULATION: Method that calculates average mood
    public double getAverageMood() {
        if (moodHistory.isEmpty()) return 0.0;

        int sum = 0;
        for (HealthEntry entry : moodHistory) {
            sum += entry.getValue();
        }
        return (double) sum / moodHistory.size();
    }

    // ENCAPSULATION: Method for stress average calculation
    public double getAverageStress() {
        if (stressHistory.isEmpty()) return 0.0;

        int sum = 0;
        for (HealthEntry entry : stressHistory) {
            sum += entry.getValue();
        }
        return (double) sum / stressHistory.size();
    }

    // ENCAPSULATION: Accessor method for current mood
    public int getCurrentMood() {
        if (moodHistory.isEmpty()) return 0;
        return moodHistory.get(moodHistory.size() - 1).getValue();
    }

    // ENCAPSULATION: Accessor method for current stress
    public int getCurrentStress() {
        if (stressHistory.isEmpty()) return 0;
        return stressHistory.get(stressHistory.size() - 1).getValue();
    }

    // ENCAPSULATION: Getter returns defensive copy
    public ArrayList<HealthEntry> getMoodHistory() {
        return new ArrayList<>(moodHistory);
    }

    // ENCAPSULATION: Getter returns defensive copy
    public ArrayList<HealthEntry> getStressHistory() {
        return new ArrayList<>(stressHistory);
    }
}
