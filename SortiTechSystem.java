import java.util.*;

// Abstract class (Abstraction)
abstract class WasteRecord {
    protected String date;
    protected float amountReduced;

    public WasteRecord(String date, float amountReduced) {
        this.date = date;
        this.amountReduced = amountReduced;
    }

    public abstract void displayRecord();

    public String getDate() { return date; }
    public float getAmountReduced() { return amountReduced; }
    public void setDate(String date) { this.date = date; }
    public void setAmountReduced(float amountReduced) { this.amountReduced = amountReduced; }
}

// Subclass (Inheritance)
class PlasticRecord extends WasteRecord {
    public PlasticRecord(String date, float amountReduced) {
        super(date, amountReduced);
    }

    // Method overriding (Polymorphism)
    @Override
    public void displayRecord() {
        System.out.printf(" Date: %s |  Plastic Reduced: %.2fg%n", date, amountReduced);
    }
}

// Main class
public class SortiTechSystem {
    private static final int MAX_RECORDS = 100;
    private static PlasticRecord[] records = new PlasticRecord[MAX_RECORDS];
    private static int recordCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showIntro();
    }

    // Startup screen
    private static void showIntro() {
        System.out.println("\n");
        System.out.println("                             WELCOME TO");
        System.out.println("=======================================================================\n");
        System.out.println("███████╗ ██████╗ ██████╗ ████████╗██╗████████╗███████╗ ██████╗██╗  ██╗");
        System.out.println("██╔════╝██╔═══██╗██╔══██╗╚══██╔══╝██║╚══██╔══╝██╔════╝██╔════╝██║  ██║");
        System.out.println("███████╗██║   ██║██████╔╝   ██║   ██║   ██║   █████╗  ██║     ███████║");
        System.out.println("╚════██║██║   ██║██╔══██╗   ██║   ██║   ██║   ██╔══╝  ██║     ██║  ██║");
        System.out.println("███████║╚██████╔╝██║  ██║   ██║   ██║   ██║   ███████╗╚██████╗██║  ██║");
        System.out.println("╚══════╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝   ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝");
        System.out.println("=======================================================================");
        System.out.println("               Smart Waste Sorting and Collection System");
        System.out.println("           Developed by: Wonder Pets (Antonio | Alea | Esleta)");
        System.out.println("=======================================================================\n");

        int choice;
        do {
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = 0;
            }

            switch (choice) {
                case 1: startTracker(); break;
                case 2: showHelp(); break;
                case 3: System.out.println("\nThank you for using SORTITECH. Goodbye!\n"); break;
                default: System.out.println("Invalid choice, try again!");
            }

        } while (choice != 3);
    }

    // Help section
    private static void showHelp() {
        System.out.println("\n========== HELP ==========");
        System.out.println("Tracks your daily plastic waste reduction.");
        System.out.println("1. Add entries");
        System.out.println("2. Search, delete, or sort your data");
        System.out.println("3. Display saved records");
        System.out.println("=============================\n");
    }

    // Main menu
    private static void startTracker() {
        int choice;

        do {
            System.out.println("\n=====================================");
            System.out.println("        SORTITECH Tracker Menu");
            System.out.println("=====================================");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Search Record");
            System.out.println("4. Sort Records");
            System.out.println("5. Display All Records");
            System.out.println("6. Back to Main Menu");
            System.out.print("-------------------------------------\nEnter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                choice = 0;
            }

            switch (choice) {
                case 1: addRecord(); break;
                case 2: deleteRecord(); break;
                case 3: searchRecord(); break;
                case 4: sortRecords(); break;
                case 5: displayRecords(); break;
                case 6: System.out.println("Returning to main menu..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    // Add new record
    private static void addRecord() {
        if (recordCount >= MAX_RECORDS) {
            System.out.println("Maximum record limit reached!");
            return;
        }

        try {
            System.out.print("\nEnter date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            System.out.print("Enter plastic reduced (in grams): ");
            float amount = Float.parseFloat(sc.nextLine());

            records[recordCount++] = new PlasticRecord(date, amount);
            System.out.println("Record added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values for grams.");
        }
    }

    // Delete record
    private static void deleteRecord() {
        System.out.print("\nEnter date to delete: ");
        String delDate = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < recordCount; i++) {
            if (records[i].getDate().equals(delDate)) {
                found = true;

                for (int j = i; j < recordCount - 1; j++) {
                    records[j] = records[j + 1];
                }

                recordCount--;
                System.out.println("Record deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("No record found for: " + delDate);
        }
    }

    // Search a record
    private static void searchRecord() {
        System.out.print("\nEnter date to search: ");
        String searchDate = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < recordCount; i++) {
            if (records[i].getDate().equals(searchDate)) {
                System.out.println("\nRecord Found:");
                records[i].displayRecord();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No record found.");
        }
    }

    // Sort records by amount reduced
    private static void sortRecords() {
        for (int i = 0; i < recordCount - 1; i++) {
            for (int j = 0; j < recordCount - i - 1; j++) {
                if (records[j].getAmountReduced() < records[j + 1].getAmountReduced()) {
                    PlasticRecord temp = records[j];
                    records[j] = records[j + 1];
                    records[j + 1] = temp;
                }
            }
        }

        System.out.println("Records sorted from highest to lowest!");
    }

    // Display all records
    private static void displayRecords() {
        if (recordCount == 0) {
            System.out.println("No records to display.");
            return;
        }

        System.out.println("\n=============================");
        System.out.println(" Plastic Waste Reduction Records ");
        System.out.println("=============================");

        for (int i = 0; i < recordCount; i++) {
            System.out.print((i + 1) + ". ");
            records[i].displayRecord();
        }

        System.out.println("-------------------------------------");
    }
}