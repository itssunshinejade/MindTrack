import java.util.ArrayList;

// ENCAPSULATION: This class encapsulates all physical health data
// COMPOSITION: This class is composed into Patient objects (Patient HAS-A PhysicalHealthProfile)
public class PhysicalHealthProfile {

    // ENCAPSULATION: Private final fields protect vital signs data integrity
    // COMPOSITION: Collections contain HealthEntry objects (HAS-A relationship)
    private final ArrayList<HealthEntry> heartRateHistory;
    private final ArrayList<HealthEntry> bloodPressureHistory;
    private final ArrayList<HealthEntry> bloodSugarHistory;

    // ENCAPSULATION: Constructor initializes all health tracking collections
    public PhysicalHealthProfile() {
        this.heartRateHistory = new ArrayList<>();
        this.bloodPressureHistory = new ArrayList<>();
        this.bloodSugarHistory = new ArrayList<>();
    }

    // ENCAPSULATION: Public method that encapsulates validation and saving logic
    public void addVitalsEntry(int heartRate, int bloodPressure, int bloodSugar) {
        boolean valid = true;

        if (heartRate >= 40 && heartRate <= 200) {
            heartRateHistory.add(new HealthEntry("heart_rate", heartRate));
            if (heartRate < 60 || heartRate > 100) {
                System.out.println("Note: Heart rate " + heartRate + " bpm is outside normal resting range.");
            }
        } else {
            System.out.println("Invalid heart rate. Must be between 40-200 bpm.");
            valid = false;
        }

        if (bloodPressure >= 70 && bloodPressure <= 190) {
            bloodPressureHistory.add(new HealthEntry("blood_pressure", bloodPressure));
            if (bloodPressure > 130) {
                System.out.println("Note: Blood pressure " + bloodPressure + " mmHg is elevated.");
            }
        } else {
            System.out.println("Invalid blood pressure. Must be between 70-190 mmHg.");
            valid = false;
        }

        if (bloodSugar >= 50 && bloodSugar <= 400) {
            bloodSugarHistory.add(new HealthEntry("blood_sugar", bloodSugar));
            if (bloodSugar < 70 || bloodSugar > 130) {
                System.out.println("Note: Blood sugar " + bloodSugar + " mg/dL is outside normal range.");
            }
        } else {
            System.out.println("Invalid blood sugar. Must be between 50-400 mg/dL.");
            valid = false;
        }

        if (valid) {
            System.out.println("Physical vitals saved successfully!");
        }
    }

    public void displayHistory() {
        System.out.println("\n=== Physical Health Summary ===");
        
        System.out.println("\nHeart Rate History:");
        if (heartRateHistory.isEmpty()) {
            System.out.println("  No heart rate entries yet.");
        } else {
            for (HealthEntry entry : heartRateHistory) {
                System.out.println("  [" + entry.getFormattedTimestamp() + "] Heart Rate: " + entry.getValue() + " bpm");
            }
        }

        System.out.println("\nBlood Pressure History:");
        if (bloodPressureHistory.isEmpty()) {
            System.out.println("  No blood pressure entries yet.");
        } else {
            for (HealthEntry entry : bloodPressureHistory) {
                System.out.println("  [" + entry.getFormattedTimestamp() + "] Blood Pressure: " + entry.getValue() + " mmHg");
            }
        }

        System.out.println("\nBlood Sugar History:");
        if (bloodSugarHistory.isEmpty()) {
            System.out.println("  No blood sugar entries yet.");
        } else {
            for (HealthEntry entry : bloodSugarHistory) {
                System.out.println("  [" + entry.getFormattedTimestamp() + "] Blood Sugar: " + entry.getValue() + " mg/dL");
            }
        }
    }

    public int getCurrentHeartRate() {
        if (heartRateHistory.isEmpty()) return 0;
        return heartRateHistory.get(heartRateHistory.size() - 1).getValue();
    }

    public int getCurrentBloodPressure() {
        if (bloodPressureHistory.isEmpty()) return 0;
        return bloodPressureHistory.get(bloodPressureHistory.size() - 1).getValue();
    }

    public int getCurrentBloodSugar() {
        if (bloodSugarHistory.isEmpty()) return 0;
        return bloodSugarHistory.get(bloodSugarHistory.size() - 1).getValue();
    }

    public ArrayList<HealthEntry> getHeartRateHistory() {
        return new ArrayList<>(heartRateHistory);
    }

    public ArrayList<HealthEntry> getBloodPressureHistory() {
        return new ArrayList<>(bloodPressureHistory);
    }

    public ArrayList<HealthEntry> getBloodSugarHistory() {
        return new ArrayList<>(bloodSugarHistory);
    }
}
