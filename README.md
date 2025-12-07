#  Mind Track: Where Mental Clarity Meets Physical Vitality

## Description/Overview
**Mind Track** is an integrated health management system that helps individuals maintain both mental and physical well-being with a single, user-friendly, console-based platform. It allows users to log their daily moods, stress levels, and self-care activities while tracking vital signs, such as heart rate, blood pressure, and blood sugar. Therapists and physicians can securely access this data to monitor progress, deliver targeted feedback, and offer personalized recommendations. Overall, Mind Track supports a balanced approach to health by showing how mental and physical wellness are connected and by encouraging regular self-checks and communication between patients and healthcare providers.

<img width="1068" height="464" alt="image" src="https://github.com/user-attachments/assets/ad91b981-5937-443e-be26-212826741cd1" />



 
## 🪧 Features
- **Mood & stress logging** — patients record mood (1–10) and stress (1–10); the system validates input and stores timestamped entries.
- **Vital sign monitoring** — patients enter heart rate, systolic blood pressure, and blood sugar; the app validates ranges and stores timestamped entries.
- **Patient summaries & history** — patients (and professionals) can view historical logs and averages for mental metrics and full histories for physical metrics.
- **Therapist & Doctor feedback** — professionals can select a patient and leave timestamped feedback messages that are stored with the patient’s record.
- **Role-based interfaces** — three user roles (Patient, Therapist, Doctor) each have their own menu and allowed operations.

 
 
##  OOP Concepts Demonstrated
- #### **Encapsulation**
`Sensitive data (IDs, email, password, health histories)` are stored in fields and exposed through getters or dedicated methods rather than public fields. Examples : User, Patient, HealthEntry, MentalHealthProfile, PhysicalHealthProfile, and Feedback.

- #### **Inheritance**
`User` is the _abstract base class_. `Patient and Professional` _inherit from User_. `Professional` is _abstract_ and is `extended by Therapist and Doctor`. This multi-level inheritance reduces repetition and models real-world roles.

- #### **Polymorphism**
Methods like `displayMenu()` are _declared in User and overridden in Patient, Therapist, and Doctor_ so each role has its own menu and behavior. **Professional** defines `displayPatientInfo()` as _abstract_; Therapist and Doctor implement it differently (mental vs physical view).

- #### **Abstraction**
`User and Professional` are _abstract classes_ that define required behaviors while leaving implementation details to subclasses. This provides a clean contract for role-specific classes.




## ⚙️ TECHNOLOGIES USED
- Programming Language: Java
- Framework : JavaFX (for GUI implementation)
- IDE: IntelliJ IDEA
- Version Control: Git and GitHub



 
## 🏢PROJECT STRUCTURE
 The program is organized as follows:
```
 MindTrack/
  ├─src/ 
    ├─ Main.java
    ├─ User.java
    ├─ Patient.java
    ├─ Professional.java
    ├─ Therapist.java
    ├─ Doctor.java
    ├─ MentalHealthProfile.java
    ├─ PhysicalHealthProfile.java
    ├─ Feedback.java
    └─ HealthEntry.java
```


 
### 💨To Run the Program

**Step 1: Install Requirements**
 - First, make sure that Java JDK is installed. The recommended version is JDK 17 or higher.
 - Next, open Visual Studio Code and install the extensions:
   - Extension Pack for Java
   - Debugger for Java
   - Java Development Tools (JDT)
These extensions allow VS Code to compile, run, and debug Java programs.

**Step 2: Open the MindTrack Project**
- Place all .java files in one folder.
- Open VS Code → Click File → Open Folder → Select the MindTrack folder.
- You will see all the classes such as Main.java, Patient.java, Therapist.java, and the profile classes.

**Step 3: Run the Program**
- Go to Main.java (this is the entry point).
- At the upper right corner, click the Run button (▶).
- Or right-click inside the code and choose Run Java.
VS Code will automatically compile and run all .java files in the folder.

**Step 4: Using the Program**
- After running, the console window will appear at the bottom of VS Code.
- It will show the login screen and the seeded demo accounts.
- Users can log in as Patient, Therapist, or Doctor and interact with the menus


## Sample Output
<img width="386" height="536" alt="image" src="https://github.com/user-attachments/assets/1b372592-e21b-4c17-b9ed-b8033b95ab75" />



<img width="355" height="538" alt="image" src="https://github.com/user-attachments/assets/2b0da081-fd87-4266-b02a-f98c81776cdc" />







## For Future Enhancements
``` Here are the possible future enhancements:
- Convert from Console to GUI or Animated Interface     
- Develop a Web-Based Version (Online Access
& Login System)
- Allow Deleting or Editing Past Health History
- Improve Password Security (Hashing,Encryption, Strength Checker)
- Add Image Upload Feature for Body Condition
- Implement Data Storage (Files or Database)
- Add Charts & Graphs for Mood and Vital Trends       
- Notification / Reminder System for Logging Health
- Cloud Sync & Multi-Device Support
- AI-Based Suggestions or Health Pattern Detection
```



## Acknowledgement
Team QuadroBees genuinely extends their gratitude to their professor for his guidance and instructions provided althroughout the completion of this project in OOP course. The team also want to thank for those helpful resources.


## 👥 Contributors 👥
| Name | Contact | 
| :--- |-----------|
|Bacsa, Baby Jane B. | [![Bjane](https://img.shields.io/badge/Github-%23181717?style=plastic&logo=github&logoColor=blue&labelColor=black&color=black)](https://github.com/bbyjane2)| 
|Bacus, Fatima Joy A. |[![Fatima](https://img.shields.io/badge/Github-%23181717?style=plastic&logo=github&logoColor=violet&labelColor=black&color=black)](https://github.com/FATIMABACUS13)|
|Barredo, Renzo Reden C. |[![Renzo](https://img.shields.io/badge/Github-%23181717?style=plastic&logo=github&logoColor=red&labelColor=black&color=black)](https://github.com/RenzoBarredo)|
|Batronel, Sunshine Jade B. | [![Sunshine](https://img.shields.io/badge/Github-%23181717?style=plastic&logo=github&logoColor=yellow&labelColor=black&color=black)](https://github.com/itssunshinejade)|         




## REFERENCES
[![Unicode](https://img.shields.io/badge/Unicode-%23111111?style=plastic&logo=%23111111&logoColor=red&labelColor=black&color=black)](https://www.compart.com/en/unicode/block/U+2500) 
[![SimpleIcons](https://img.shields.io/badge/Simpleicons-%23111111?style=plastic&logo=%23111111&logoColor=red&labelColor=black&color=black)](https://simpleicons.org/) 
[![StaticBadge](https://img.shields.io/badge/static%20badge-000000?style=plastic&logo=non&logoColor=red&labelColor=white&color=green)](https://shields.io/badges/static-badge)
[![VSCode](https://img.shields.io/badge/VS%20Code-000000?style=plastic&logo=non&logoColor=red&labelColor=white&color=blue)](https://code.visualstudio.com/)
[![Github](https://img.shields.io/badge/Github-000000?style=plastic&logo=github&logoColor=white&labelColor=black&color=black)](https://github.com/)
[![Java](https://img.shields.io/badge/Java-000000?style=plastic&color=orange)](https://www.oracle.com/java/)


## 🗒️ NOTE 🗒️
_This project is solely developed for Object Oriented Programming (OOP) course that is intended for academic purposes to demonstrate the teams proficiency on OOP principles._


