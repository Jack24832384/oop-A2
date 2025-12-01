/**
 * Main class for assessment (corresponds to Assessment Part1)
 * Contains demonstration methods for all parts; validates code functionality
 */
public class AssignmentTwo {
    /**
     * Program entry point
     * Calls demo methods for each part sequentially; outputs validation results
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo(); // Create instance for non-static methods

        System.out.println("=== Starting Part3 Demo: Waiting Queue Management ===");
        assignment.partThree();

        System.out.println("\n\n=== Starting Part4A Demo: Ride History Management ===");
        assignment.partFourA();

        System.out.println("\n\n=== Starting Part4B Demo: Ride History Sorting ===");
        assignment.partFourB();

        System.out.println("\n\n=== Starting Part5 Demo: Ride Cycle Operation ===");
        assignment.partFive();

        System.out.println("\n\n=== Starting Part6 Demo: Export History to File ===");
        assignment.partSix();

        System.out.println("\n\n=== Starting Part7 Demo: Import History from File ===");
        assignment.partSeven();
    }

    // ------------------------------ Part3: Queue Demo ------------------------------
    /**
     * Demonstrate queue functionality: Create ride → Add 5 visitors → Remove 1 → Print queue
     */
    public void partThree() {
        // 1. Create operator (for Ride initialization)
        Employee operator = new Employee("P001", "John Doe", 35, "E001", "Roller Coaster Operator");
        // 2. Create ride (max 2 riders per cycle)
        Ride rollerCoaster = new Ride(operator, "Roller Coaster", "Thrill Ride", 2);
        // 3. Add 5 visitors to queue
        rollerCoaster.addVisitorToQueue(new Visitor("V001", "Alice", 22, "VIS001", "Standard"));
        rollerCoaster.addVisitorToQueue(new Visitor("V002", "Bob", 25, "VIS002", "VIP"));
        rollerCoaster.addVisitorToQueue(new Visitor("V003", "Charlie", 18, "VIS003", "Standard"));
        rollerCoaster.addVisitorToQueue(new Visitor("V004", "Diana", 30, "VIS004", "VIP"));
        rollerCoaster.addVisitorToQueue(new Visitor("V005", "Eve", 28, "VIS005", "Standard"));
        // 4. Print queue (after additions)
        rollerCoaster.printQueue();
        // 5. Remove 1 visitor (front of queue)
        rollerCoaster.removeVisitorFromQueue();
        // 6. Print queue (after removal)
        rollerCoaster.printQueue();
    }

    // ------------------------------ Part4A: History Demo ------------------------------
    /**
     * Demonstrate history functionality: Create ride → Add 5 visitors → Check existence → Print count → Print history
     */
    public void partFourA() {
        // 1. Create ride (no operator assigned yet)
        Ride thunderstorm = new Ride(null, "Thunderstorm", "Water Ride", 4);
        // 2. Create visitor objects
        Visitor v1 = new Visitor("V006", "Tom", 21, "VIS006", "Standard");
        Visitor v2 = new Visitor("V007", "Sherly", 24, "VIS007", "VIP");
        Visitor v3 = new Visitor("V008", "Ben", 19, "VIS008", "Standard");
        Visitor v4 = new Visitor("V009", "David", 27, "VIS009", "VIP");
        Visitor v5 = new Visitor("V010", "Lisa", 23, "VIS010", "Standard");
        // 3. Add visitors to history
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);
        // 4. Check if specific visitor exists
        Visitor checkV = new Visitor("V007", "Sherly", 24, "VIS007", "VIP");
        System.out.println("\nVisitor " + checkV.getName() + " in history? " + thunderstorm.checkVisitorFromHistory(checkV));
        // 5. Print history count
        System.out.println("Total visitors in history: " + thunderstorm.numberOfVisitors());
        // 6. Print full history (uses Iterator)
        thunderstorm.printRideHistory();
    }

    // ------------------------------ Part4B: Sorting Demo ------------------------------
    /**
     * Demonstrate history sorting: Create ride → Add visitors → Print before sort → Sort → Print after sort
     */
    public void partFourB() {
        // 1. Create ride
        Ride ferrisWheel = new Ride(null, "Ferris Wheel", "Family Ride", 6);
        // 2. Add 5 visitors (unordered by age/name)
        ferrisWheel.addVisitorToHistory(new Visitor("V011", "Mike", 32, "VIS011", "Standard"));
        ferrisWheel.addVisitorToHistory(new Visitor("V012", "Anna", 22, "VIS012", "VIP"));
        ferrisWheel.addVisitorToHistory(new Visitor("V013", "Jack", 22, "VIS013", "Standard"));
        ferrisWheel.addVisitorToHistory(new Visitor("V014", "Zoe", 28, "VIS014", "VIP"));
        ferrisWheel.addVisitorToHistory(new Visitor("V015", "Chris", 25, "VIS015", "Standard"));
        // 3. Print before sorting
        System.out.println("\n=== Ride History Before Sorting ===");
        ferrisWheel.printRideHistory();
        // 4. Perform sort
        ferrisWheel.sortRideHistory();
        // 5. Print after sorting
        System.out.println("\n=== Ride History After Sorting ===");
        ferrisWheel.printRideHistory();
    }

    // ------------------------------ Part5: Cycle Demo ------------------------------
    /**
     * Demonstrate ride cycles: Create ride → Add 10 visitors → Print queue before → Run cycle → Print queue/history after
     */
    public void partFive() {
        // 1. Create operator
        Employee operator = new Employee("P002", "Sarah", 30, "E002", "Water Ride Operator");
        // 2. Create ride (max 3 riders per cycle)
        Ride logFlume = new Ride(operator, "Log Flume", "Water Ride", 3);
        // 3. Add 10 visitors to queue
        for (int i = 1; i <= 10; i++) {
            logFlume.addVisitorToQueue(new Visitor(
                    "V" + String.format("%03d", 16 + i),
                    "Visitor" + i,
                    18 + (i % 10),
                    "VIS" + String.format("%03d", 16 + i),
                    i % 2 == 0 ? "VIP" : "Standard"
            ));
        }
        // 4. Print queue before cycle
        System.out.println("=== Waiting Queue Before Cycle ===");
        logFlume.printQueue();
        // 5. Run 1 cycle
        logFlume.runOneCycle();
        // 6. Print queue after cycle
        System.out.println("\n=== Waiting Queue After Cycle ===");
        logFlume.printQueue();
        // 7. Print history after cycle
        System.out.println("\n=== Ride History After Cycle ===");
        logFlume.printRideHistory();
    }

    // ------------------------------ Part6: Export Demo ------------------------------
    /**
     * Demonstrate file export: Create ride → Add visitors → Export to CSV
     */
    public void partSix() {
        // 1. Create ride
        Ride carousel = new Ride(null, "Carousel", "Kids Ride", 5);
        // 2. Add 5 child visitors to history
        carousel.addVisitorToHistory(new Visitor("V027", "Lily", 8, "VIS027", "Standard"));
        carousel.addVisitorToHistory(new Visitor("V028", "Lucas", 7, "VIS028", "Standard"));
        carousel.addVisitorToHistory(new Visitor("V029", "Emma", 9, "VIS029", "VIP"));
        carousel.addVisitorToHistory(new Visitor("V030", "Noah", 6, "VIS030", "Standard"));
        carousel.addVisitorToHistory(new Visitor("V031", "Olivia", 8, "VIS031", "VIP"));
        // 3. Export to CSV (project root directory)
        carousel.exportRideHistory("carousel_ride_history.csv");
    }

    // ------------------------------ Part7: Import Demo ------------------------------
    /**
     * Demonstrate file import: Create ride → Import from CSV → Verify results (count + details)
     */
    public void partSeven() {
        // 1. Create ride
        Ride carouselImport = new Ride(null, "Carousel (Import)", "Kids Ride", 5);
        // 2. Import from Part6 CSV
        carouselImport.importRideHistory("carousel_ride_history.csv");
        // 3. Verify import count
        System.out.println("\nTotal imported records: " + carouselImport.numberOfVisitors());
        // 4. Verify import details
        System.out.println("=== Imported Ride History ===");
        carouselImport.printRideHistory();
    }
}